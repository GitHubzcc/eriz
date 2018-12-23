package com.eriz.sys.dao;

import com.eriz.common.base.BaseDao;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.domain.UserRoleDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
public interface UserDao extends BaseDao<UserDo> {

    Long[] listAllDept();

    int addUser(UserDo userDo);

    int removeUserRole(@Param("uid") Long uid);

    int insertUserRole(@Param("ids") List<UserRoleDo> ids);
}

