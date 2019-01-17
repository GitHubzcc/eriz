package com.eriz.app.controller;

import com.eriz.common.util.Result;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping(value = "/swagger")
@Controller
public class SwaggerController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("user/{id}")
    @ResponseBody
    public Result user(@PathVariable(value = "id") Long id) {
        UserDo userDo = userService.selectById(id);
        return Result.build(0, "success", userDo);
    }

    @ApiOperation(value = "获取用户详细信息2", notes = "根据url的id来获取用户详细信息2")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("user/{name}/{id}")
    @ResponseBody
    public Result user2(@PathVariable(value = "name") String name, @PathVariable(value = "id") Long id) {
        System.out.println(name);
        UserDo userDo = userService.selectById(id);
        return Result.build(0, "success", userDo);
    }
}
