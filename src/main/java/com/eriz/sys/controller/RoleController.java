package com.eriz.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.base.BaseController;
import com.eriz.common.util.Result;
import com.eriz.common.util.WebUtil;
import com.eriz.sys.domain.RoleDO;
import com.eriz.sys.service.RoleService;
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
 * 角色模块
 * 2018年12月13日 eriz
 */
@RequestMapping(value = "sys/role")
@Controller
@ApiIgnore
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @GetMapping(value = "/")
    public String list() {
        return "sys/role/lists";
    }

    @ResponseBody
    @PostMapping(value = "list")
    public Result<List<RoleDO>> roleList(RoleDO roleDo) {
        Page<RoleDO> page = roleService.selectPage(getPage(RoleDO.class),
                new EntityWrapper<RoleDO>().like("roleName", WebUtil.getParameter("keyword")));
        return Result.success(0, "成功", page.getTotal(), page.getRecords());
    }

    /**
     * 添加/编辑 用户
     */
    @RequestMapping(value = "add")
    public String add(Model model, Long rid) {
        RoleDO role = roleService.selectById(rid);
        model.addAttribute("role", role);
        return "sys/role/add";
    }

    /**
     * 保存/编辑 角色
     */
    @ResponseBody
    @PostMapping(value = "save")
    public Result save(RoleDO roleDo) {
        return roleService.insert(roleDo) ? Result.success() : Result.fail();
    }

    /**
     * 刪除角色
     */
    @ResponseBody
    @PostMapping(value = "remove")
    public Result remove(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return roleService.deleteBatchIds(list) ? Result.success() : Result.fail();
    }

}
