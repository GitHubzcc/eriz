package com.eriz.sys.sysCore;

import com.eriz.sys.domain.RoleDo;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.MenuService;
import com.eriz.sys.service.RoleService;
import com.eriz.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <pre>
 *     系统权限控制
 * </pre>
 * <small> 2018年12月18日 | eriz</small>
 */
@Component
public class SysShiroRealm extends AuthorizingRealm {

    private MenuService menuService;
    private RoleService roleService;
    private UserService userService;


    @Autowired
    private void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 权限
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String loginName = (String) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo authenticationInfo = null;
        if (loginName != null) {
            UserDo userDo = userService.findOneByKv("username", loginName);
            //角色授权
            List<RoleDo> roleList = roleService.userRole(userDo.getId());
            Set<String> roles = new HashSet<>();
            for (RoleDo role : roleList) {
                roles.add(role.getRoleSign());
            }
            authenticationInfo = new SimpleAuthorizationInfo();
            authenticationInfo.setRoles(roles);
            //获取权限perms
            Set<String> permsSet = menuService.findPermByUserId(userDo.getId());
            authenticationInfo.setStringPermissions(permsSet);
        }
        return authenticationInfo;
    }

    /**
     * 用户验证
     *
     * @param token token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (!supports(token)) {
            return null;
        }
        //获取登陆名
        String name = (String) token.getPrincipal();
        String paw = new String((char[]) token.getCredentials());
        // 查询用户信息
        UserDo userDo = userService.findOneByKv("username", name);
        // 账号不存在
        if (userDo == null) {
            throw new UnknownAccountException("账号不存在");
        }
        // 密码错误
        if (!paw.equals(userDo.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        // 账号锁定
        if (userDo.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        //设置系统session
        return new SimpleAuthenticationInfo(userDo, paw, getName());
    }
}
