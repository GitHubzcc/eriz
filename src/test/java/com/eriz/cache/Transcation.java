package com.eriz.cache;

import com.eriz.Application;
import com.eriz.sys.domain.UserDO;
import com.eriz.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Transcation {

    @Autowired
    private UserService userService;

    @Test
    public void transcation() {
        UserDO userDO = userService.transcation("eriz");
        System.out.println("-------------------------");
        System.out.println(userDO.toString());
    }
}
