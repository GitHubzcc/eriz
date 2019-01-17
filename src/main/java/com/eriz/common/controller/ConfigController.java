package com.eriz.common.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.annotation.Log;
import com.eriz.common.base.BaseController;
import com.eriz.common.domain.ConfigDo;
import com.eriz.common.service.ConfigService;
import com.eriz.common.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;

/**
 * <pre>
 *  controller
 * </pre>
 * <small> 2019-01-07 15:35:10 | eriz</small>
 */
@Controller
@RequestMapping("/common/config")
@ApiIgnore
public class ConfigController extends BaseController {
    @Autowired
    private ConfigService configService;

    @GetMapping(value = "/")
    @RequiresPermissions("common:config:config")
    public String sysConfig() {
        return "common/config/config";
    }

    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("common:config:config")
    public Result list(ConfigDo sysConfigDTO) {
        Wrapper<ConfigDo> wrapper = new EntityWrapper<ConfigDo>().orderBy("id", false);
        Page<ConfigDo> page = configService.selectPage(getPage(ConfigDo.class), wrapper);
        return Result.success(0, "success", page.getTotal(), page.getRecords());
    }

    @GetMapping("/add")
    @RequiresPermissions("common:config:add")
    public String add() {
        return "common/config/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("common:config:edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        ConfigDo sysConfig = configService.selectById(id);
        model.addAttribute("sysConfig", sysConfig);
        return "common/config/edit";
    }

    @Log("添加")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("common:config:add")
    public Result save(ConfigDo sysConfig) {
        configService.insert(sysConfig);
        return Result.success();
    }

    @Log("修改")
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("common:config:edit")
    public Result<String> update(ConfigDo sysConfig) {
        boolean update = configService.updateById(sysConfig);
        return update ? Result.success() : Result.fail();
    }

    @Log("删除")
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("common:config:remove")
    public Result remove(Long id) {
        configService.deleteById(id);
        return Result.success();
    }

    @Log("批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("common:config:batchRemove")
    public Result batchRemove(@RequestParam("ids[]") Long[] ids) {
        configService.deleteBatchIds(Arrays.asList(ids));
        return Result.success();
    }

}
