package com.eriz.cache;

import com.eriz.Application;
import com.eriz.common.shiro.cache.EhcacheUtil;
import com.eriz.sys.domain.RoleDO;
import com.eriz.sys.domain.UserDO;
import com.eriz.sys.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Ehcache {

    @Resource
    private RoleService roleService;

    @Test
    public void role() {

        RoleDO roleDO = new RoleDO();
        roleDO.setRoleName("超级用户角色");
        List<RoleDO> list = roleService.all(roleDO);

        list.forEach(kv -> System.out.println(kv.getRoleName()));
        System.out.println("==========分割线=============");
        List<RoleDO> list1 = roleService.all(roleDO);

        list1.forEach(k-> System.out.println(k.getRoleName()));
    }

}
