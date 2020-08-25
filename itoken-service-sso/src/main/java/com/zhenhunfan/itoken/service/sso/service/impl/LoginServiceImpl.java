package com.zhenhunfan.itoken.service.sso.service.impl;

import com.zhenhunfan.itoken.common.domain.TbSysUser;
import com.zhenhunfan.itoken.common.utils.MapperUtils;
import com.zhenhunfan.itoken.service.sso.mapper.TbSysUserMapper;
import com.zhenhunfan.itoken.service.sso.service.LoginService;
import com.zhenhunfan.itoken.service.sso.service.consumer.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * <p>Title: LoginServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/18
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {

        TbSysUser tbSysUser =null;
        String json = redisService.get(loginCode);

        if(json==null){//缓存中没有数据
            Example example = new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode",loginCode);

            tbSysUser = tbSysUserMapper.selectOneByExample(example);
            String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
            if(tbSysUser != null && password.equals(tbSysUser.getPassword())){
                try {
                    redisService.put(loginCode,MapperUtils.obj2json(tbSysUser), (long) (60 * 60 * 24));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return tbSysUser;
            }else{
                return null;
            }
        }else{//缓存中有数据
            try {

                tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
            } catch (Exception e) {
                logger.warn("触发熔断：{}",e.getMessage());
            }
        }

        return tbSysUser;
    }
}
