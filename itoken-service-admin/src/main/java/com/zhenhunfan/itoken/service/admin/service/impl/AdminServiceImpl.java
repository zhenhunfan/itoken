package com.zhenhunfan.itoken.service.admin.service.impl;


import com.zhenhunfan.itoken.common.domain.TbSysUser;
import com.zhenhunfan.itoken.common.mapper.TbSysUserMapper;
import com.zhenhunfan.itoken.common.service.impl.BaseServiceImpl;
import com.zhenhunfan.itoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements AdminService<TbSysUser> {
}
