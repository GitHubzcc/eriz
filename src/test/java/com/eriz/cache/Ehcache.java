package com.eriz.cache;

import com.eriz.Application;
import com.eriz.common.shiro.cache.EhcacheUtil;
import com.eriz.sys.domain.RoleDO;
import com.eriz.sys.domain.UserDo;
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

    public static final String THING_ALL_KEY = "\"thing_all\"";
    public static final String DEMO_CACHE_NAME = "role";

    @Test
    public void role() {
        List<RoleDO> list = roleService.userRole(null);
        EhcacheUtil.put("list", list);
        Object o = EhcacheUtil.get("list");
        System.out.println(o);
        list.forEach(kv -> System.out.println(kv.getRoleName()));
    }

    @Test
    public void ehcache() {
        System.out.println("ehcache 缓存开始：");
        findAll();
    }

    @CacheEvict(cacheNames = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    public UserDo create(UserDo userDo) {
        return userDo;
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = "#userDo.getId()+'thing'")
    public UserDo findById(Long id) {
        System.err.println("没有走缓存！" + id);
        UserDo userDo = new UserDo();
        userDo.setId(id);
        return userDo;
    }

    @Cacheable(cacheNames = DEMO_CACHE_NAME, key = THING_ALL_KEY)
    public List<UserDo> findAll() {
        System.out.println("进入缓存============");
        List<UserDo> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserDo userDo = new UserDo();
            userDo.setId(2L + i);
            userDo.setName("didi" + i);
        }
        return list;
    }

}
