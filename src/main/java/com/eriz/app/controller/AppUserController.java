package com.eriz.app.controller;

import com.eriz.app.pojo.dto.UserLoginDTO;
import com.eriz.app.pojo.dto.UserLogoutDTO;
import com.eriz.app.pojo.vo.TokenVO;
import com.eriz.app.service.AppUserService;
import com.eriz.common.annotation.Log;
import com.eriz.common.util.Result;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *  基于jwt实现的API测试类
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
@RestController
@RequestMapping("/api/user/")
public class AppUserController {
    @Autowired
    private AppUserService userService;

    @PostMapping("login")
    @Log("api测试-登录")
    public Result token(UserLoginDTO loginDTO) {
        TokenVO token = userService.getToken(loginDTO.getUname(), loginDTO.getPasswd());
        return Result.success(token);
    }

    @PostMapping("refresh")
    @Log("api测试-刷新token")
    public Result<?> refresh(@RequestParam String uname, @RequestBody final String refreshToken) {
        TokenVO token = userService.refreshToken(uname, refreshToken);
        return Result.success(token);
    }

    @PostMapping("logout")
    @Log("api测试-注销token")
    public Result<?> logout(@RequestBody UserLogoutDTO dto) {
        userService.logoutToken(dto.getToken(), dto.getRefreshToken());
        return Result.success();
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    @Log("api测试-需要认证才能访问")
    public Result<?> requireAuth() {
        return Result.build(200, "认证通过", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("apiRole")
    @Log("api测试-需要api角色才能访问")
    public Result<?> requireRole() {
        return Result.build(200, "用户有role角色权限", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions("api:user:update")
    @Log("api测试-需要api:user:update权限才能访问")
    public Result<?> requirePermission() {
        return Result.build(200, "用户有api:user:update权限", null);
    }

}
