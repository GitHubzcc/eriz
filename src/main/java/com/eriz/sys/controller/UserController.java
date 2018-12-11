package com.eriz.sys.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.base.SysController;
import com.eriz.common.util.Result;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.MenuService;
import com.eriz.sys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 *     系统模块
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@RequestMapping(value = "sys/user")
@Controller
public class UserController extends SysController {

    @Resource
    private UserService userService;

    @Resource
    private MenuService menuService;

    /**
     * 用户列表
     */
    @GetMapping(value = "/")
    public String userList(Model model) {
        model.addAttribute("list", userService.selectList(null));
        return "sys/user/user";
    }

    @ResponseBody
    @GetMapping(value = "userList")
    public Result<List<MenuDo>> userList(MenuDo userDo) {
        //List<UserDo> list = userService.selectList(null);
        //List<MenuDo> list = menuService.selectList(null);
        Page<MenuDo> page = menuService.selectPage(new Page<>(1,10), null);
        System.out.println(page.toString());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords().size());
        return Result.success(0, "成功", page.getRecords().size(), page.getRecords());
    }

    @RequestMapping(value = "personal")
    public String personal() {
        userService.selectById(1L);
        return "sys/user/personal";
    }

    @ResponseBody
    @RequestMapping(value = "userInfo")
    public UserDo user() {
        return userService.selectById(1L);
    }

    @ResponseBody
    @RequestMapping(value = "update")
    public int update(UserDo userDo) {
        System.out.println(userDo.getUsername());
        return 1;
    }
}
