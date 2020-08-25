package com.zhenhunfan.itoken.service.admin.test.service;

import com.zhenhunfan.itoken.service.admin.ServiceAdminApplication;
import com.zhenhunfan.itoken.service.admin.service.AdminService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@ActiveProfiles(value = "prod")
@Transactional
@Rollback
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
}
