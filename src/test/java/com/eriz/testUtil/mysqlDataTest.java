package com.eriz.testUtil;

import com.eriz.Application;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class mysqlDataTest {


    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserDo> userList = userService.selectList(null);
        //Assert.assertEquals(5, userList.size());
        for (UserDo u : userList) {
            System.out.println(u.getName());
        }
    }

}
