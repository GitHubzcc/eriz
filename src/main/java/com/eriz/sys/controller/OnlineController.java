package com.eriz.sys.controller;

import com.eriz.common.annotation.Log;
import com.eriz.common.util.Result;
import com.eriz.sys.domain.OnlineDo;
import com.eriz.sys.service.ShiroSessionService;
import org.apache.shiro.session.UnknownSessionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     系统用户管理
 * </p>
 * 2018年12月24日 | eriz
 */
@RequestMapping("sys/online")
@Controller
public class OnlineController {

    @Resource
    private ShiroSessionService shiroSessionService;

    /**
     * online page
     */
    @GetMapping("/")
    public String online() {
        return "sys/online/lists";
    }

    /**
     * online page data
     */
    @PostMapping("/list")
    @Log("用户管理")
    @ResponseBody
    public Result list() {
        List<OnlineDo> list = shiroSessionService.list();
        return Result.success(0, "操作成功", list.size(), list);
    }

    /**
     * remove
     */
    @PostMapping("/remove")
    @Log("强制用户下线")
    @ResponseBody
    public Result remove(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        try {
            shiroSessionService.removeSession(list);
            return Result.success();
        } catch (UnknownSessionException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
}
