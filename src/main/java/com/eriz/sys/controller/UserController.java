package com.eriz.sys.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.annotation.Log;
import com.eriz.common.base.BaseController;
import com.eriz.common.util.Result;
import com.eriz.sys.domain.RoleDO;
import com.eriz.sys.domain.UserDO;
import com.eriz.sys.service.RoleService;
import com.eriz.sys.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

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
@ApiIgnore
public class UserController extends BaseController {

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
    @ApiOperation("api测试-查询用户列表")
    public Result<List<UserDO>> userList(UserDO userDo) {
        Page<UserDO> page = userService.selectPage(getPage(UserDO.class),
                userService.convertToEntityWrapper("name", userDo.getName(), "deptId", userDo.getDeptId()));
        return Result.success(0, "success", page.getTotal(), page.getRecords());
    }

    /**
     * 添加/编辑 用户
     */
    @RequiresPermissions("sys:user:add")
    @RequestMapping(value = "add")
    public String add(Model model, Long uid) {
        List<RoleDO> list = roleService.userRole(uid);
        UserDO userDo = new UserDO();
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
    public Result save(UserDO userDo) {
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
    public UserDO userInfo() {
        return userService.selectById(1L);
    }

}
