package com.eriz.sys.dao;

import com.eriz.common.base.BaseDao;
import com.eriz.sys.domain.RoleDo;
import com.eriz.sys.domain.RoleMenuDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月13日 | eriz</small>
 */
public interface RoleDao extends BaseDao<RoleDo> {

    List<RoleDo> userRole(@Param("uid") Long uid);

    int deleteRoleMenu(@Param("rid") Long rid);

    int insertRoleMenu(@Param("list") List<RoleMenuDo> list);
}

