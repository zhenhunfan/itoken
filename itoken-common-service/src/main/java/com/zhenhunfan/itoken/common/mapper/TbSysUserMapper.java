package com.zhenhunfan.itoken.common.mapper;

import com.zhenhunfan.itoken.common.domain.TbSysUser;
import com.zhenhunfan.itoken.common.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.MyMapper;

@CacheNamespace(implementation = RedisCache.class)
public interface TbSysUserMapper extends MyMapper<TbSysUser> {
}