package com.eriz.sys.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 角色do
 * 2018年12月13日 eriz
 */
@TableName("sys_role")
public class RoleDo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;
    private String roleSign;
    private String remark;
    private Long userIdCreate;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    @TableField(exist = false)
    private List<Long> menuIds;
    @TableField(exist = false)
    private Long ridDo;// 查询时占用 用户的角色id

    public Long getRidDo() {
        return ridDo;
    }

    public void setRidDo(Long ridDo) {
        this.ridDo = ridDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(Long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "RoleDo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleSign='" + roleSign + '\'' +
                ", remark='" + remark + '\'' +
                ", userIdCreate=" + userIdCreate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", menuIds=" + menuIds +
                ", ridDo=" + ridDo +
                '}';
    }
}
