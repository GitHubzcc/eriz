package com.eriz.app.controller;

import com.eriz.app.pojo.dto.UserLoginDTO;
import com.eriz.app.pojo.dto.UserLogoutDTO;
import com.eriz.app.pojo.vo.TokenVO;
import com.eriz.app.service.AppUserService;
import com.eriz.common.annotation.Log;
import com.eriz.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <pre>
 *  基于jwt实现的API测试类
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
@RestController
@RequestMapping("/api/user/")
@Api("appUser操作")
public class AppUserController {
    @Autowired
    private AppUserService userService;

    @PostMapping("login")
    @Log("登录获取token")
    @ApiOperation("登录获取token")
    public Result token(UserLoginDTO loginDTO) {
        TokenVO token = userService.getToken(loginDTO.getUname(), loginDTO.getPasswd());
        return Result.success(token);
    }

    @PostMapping("refresh")
    @Log("刷新token")
    @ApiOperation("刷新token")
    public Result<?> refresh(@RequestParam String uname, @RequestBody final String refreshToken) {
        TokenVO token = userService.refreshToken(uname, refreshToken);
        return Result.success(token);
    }

    @PostMapping("logout")
    @Log("api测试-注销token")
    @ApiOperation("注销token")
    public Result<?> logout(@RequestBody UserLogoutDTO dto) {
        userService.logoutToken(dto.getToken(), dto.getRefreshToken());
        return Result.success();
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    @Log("api测试-需要认证才能访问")
    @ApiOperation("认证访问RequiresAuthentication")
    public Result<?> requireAuth() {
        return Result.build(200, "认证通过", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("apiRole")
    @Log("api测试-需要api角色才能访问")
    @ApiOperation("需要权限访问apiRole")
    public Result<?> requireRole() {
        return Result.build(200, "用户有role角色权限", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions("api:user:update")
    @Log("api测试-需要api:user:update权限才能访问")
    @ApiOperation("需要权限访问api:user:update")
    public Result<?> requirePermission() {
        return Result.build(200, "用户有api:user:update权限", null);
    }

}
