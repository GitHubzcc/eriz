package com.eriz.sys.dao;

import com.eriz.common.base.BaseDao;
import com.eriz.sys.domain.MenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
public interface MenuDao extends BaseDao<MenuDO> {

    List<String> findPermByUserId(@Param("id") Long id);

    List<MenuDO> findListByUserId(Long id);

    List<Map<String, Object>> menuTree();

    List<Map<String, Object>> menuTreeRid(@Param("keyValue") Long keyValue);
}

