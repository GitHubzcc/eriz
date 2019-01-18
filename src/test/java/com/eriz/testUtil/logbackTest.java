package com.eriz.testUtil;

import com.eriz.Application;
import com.eriz.sys.domain.RoleDO;
import com.eriz.sys.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class logbackTest {

    // init sys recored ,get by loggerFactory
    private final static Logger logger = LoggerFactory.getLogger(logbackTest.class);

    @Test
    public void logback() {
        logger.info("logback info success");
        logger.error("logback error success");
    }

    @Resource
    RoleService roleService;

    @Test
    public void sql(){
        List<RoleDO> roleDo = roleService.userRole(1L);
        roleDo.forEach(key -> System.out.println(key.getRoleName()));
    }


}
