package com.eriz.common.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.base.SysController;
import com.eriz.common.domain.LogDo;
import com.eriz.common.service.LogService;
import com.eriz.common.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 系统日志
 * 2018年12月23日 | eriz
 */
@RequestMapping("/common/log")
@Controller
public class LogController extends SysController {

    @Resource
    private LogService logService;

    /**
     * 系统日志
     */
    @GetMapping("/")
    public String log() {
        return "common/log/lists";
    }

    /**
     * 日志页面数据
     */
    @ResponseBody
    @PostMapping("list")
    public Result list() {
        Page<LogDo> page = logService.selectPage(getPage(LogDo.class), null);
        return Result.success(0, "操作成功", page.getTotal(), page.getRecords());
    }

    /**
     * 删除
     */
    @ResponseBody
    @PostMapping("remove")
    public Result remove(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return logService.deleteBatchIds(list) ? Result.success() : Result.fail();
    }
}
