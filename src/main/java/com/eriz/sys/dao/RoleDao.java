package com.eriz.sys.dao;

import com.eriz.common.base.BaseDao;
import com.eriz.sys.domain.RoleDO;
import com.eriz.sys.domain.RoleMenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月13日 | eriz</small>
 */
public interface RoleDao extends BaseDao<RoleDO> {

    List<RoleDO> userRole(@Param("uid") Long uid);

    int deleteRoleMenu(@Param("rid") Long rid);

    int insertRoleMenu(@Param("list") List<RoleMenuDO> list);
}

