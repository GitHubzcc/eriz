package com.eriz.cache;


import com.eriz.Application;
import com.eriz.common.redis.cache.RedisUtil;
import com.eriz.sys.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Redis {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void putRedis() {
        UserDO userDo = new UserDO();
        userDo.setId(1L);
        userDo.setName("admin");
        userDo.setUsername("eriz.admin");
        userDo.setEmail("eriz@163.com");
        System.out.println(redisUtil.set("test", "testputredis"));
        System.out.println(redisUtil.set("user", userDo));

        String test = (String)redisUtil.get("test");
        System.out.println(test);
        System.out.println(redisUtil.get("user"));
    }
}
