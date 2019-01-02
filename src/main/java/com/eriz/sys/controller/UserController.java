package com.eriz.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.annotation.Log;
import com.eriz.common.base.SysController;
import com.eriz.common.util.Result;
import com.eriz.common.util.WebUtil;
import com.eriz.sys.domain.RoleDo;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.RoleService;
import com.eriz.sys.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     用户模块
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@RequestMapping(value = "sys/user")
@Controller
public class UserController extends SysController {

    @Resource
    private UserService userService;


    @Resource
    private RoleService roleService;

    /**
     * 用户列表
     */
    @GetMapping(value = "/")
    @RequiresPermissions("sys:user:user")
    public String user() {
        return "sys/user/lists";
    }

    @ResponseBody
    @Log("用户列表")
    @PostMapping(value = "userList")
    public Result<List<UserDo>> userList(UserDo userDo) {
        System.out.println("get userList ================================================");
//        Page<UserDo> page = userService.selectPage(getPage(UserDo.class),
//                new EntityWrapper<UserDo>().like("name", WebUtil.getParameter("keyword")));
        Page<UserDo> page = userService.selectPage(getPage(UserDo.class),
                userService.convertToEntityWrapper("name", userDo.getName(), "deptId", userDo.getDeptId()));
        return Result.success(0, "成功", page.getTotal(), page.getRecords());
    }

    /**
     * 添加/编辑 用户
     */
    @RequiresPermissions("sys:user:add")
    @RequestMapping(value = "add")
    public String add(Model model, Long uid) {
        List<RoleDo> list = roleService.userRole(uid);
        UserDo userDo = new UserDo();
        if (uid != null) {
            userDo = userService.selectById(uid);
        }
        model.addAttribute("userDo", userDo);
        model.addAttribute("roles", list);
        return "sys/user/add";
    }

    /**
     * 保存
     *
     * @param userDo 实体
     * @return true/false
     */
    @ResponseBody
    @PostMapping(value = "save")
    public Result save(UserDo userDo) {
        return userService.insert(userDo) ? Result.success() : Result.fail();
    }


    /**
     * 删除
     */
    @ResponseBody
    @PostMapping(value = "remove")
    public Result delete(String ids) {
        boolean flag = userService.deleteBatchIds(Arrays.asList(ids.split(",")));
        return flag ? Result.success() : Result.fail();
    }

    /**
     * 个人信息
     *
     * @return
     */
    @RequestMapping(value = "personal")
    public String personal() {
        return "sys/user/personal";
    }

    @ResponseBody
    @RequestMapping(value = "userInfo")
    public UserDo userInfo() {
        return userService.selectById(1L);
    }

}
