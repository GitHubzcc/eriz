package com.eriz.sys.domain;

import java.io.Serializable;

/**
 * 角色菜单实体
 * 2018年12月14日 eriz
 */
public class RoleMenuDO implements Serializable {

    private Long id;

    private Long roleId;//角色id

    private Long menuId;//菜单id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
