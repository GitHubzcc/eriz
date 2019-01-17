package com.eriz.base.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.base.domain.DictDo;
import com.eriz.base.service.DictService;
import com.eriz.common.base.BaseController;
import com.eriz.common.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * <small> 2018年12月17日 | eriz</small>
 */
@RequestMapping(value = "base/dict")
@Controller
public class DictController extends BaseController {

    @Resource
    private DictService dictService;

    @RequestMapping(value = "/")
    @RequiresPermissions("common:sysDict:sysDict")
    public String list() {
        return "base/dict/lists";
    }

    @ResponseBody
    @PostMapping(value = "list")
    public Result dictList(DictDo dictDo) {
        Page<DictDo> list = dictService.selectPage(getPage(DictDo.class), null);
        return Result.success(0, "成功消息", list.getTotal(), list.getRecords());
    }

    /**
     * add/edit dict
     */
    @RequestMapping(value = "add")
    public String add(Model model, Long keyValue) {
        DictDo dictDo = dictService.selectById(keyValue);
        model.addAttribute("dict", dictDo);
        return "base/dict/add";
    }

    /**
     * add/edit dict
     */
    @ResponseBody
    @PostMapping(value = "save")
    public Result save(DictDo dictDo) {
        return dictService.insert(dictDo) ? Result.success() : Result.fail();
    }

    /**
     * delete
     */
    @ResponseBody
    @PostMapping(value = "remove")
    public Result remove(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return dictService.deleteBatchIds(list) ? Result.success() : Result.fail();
    }
}
