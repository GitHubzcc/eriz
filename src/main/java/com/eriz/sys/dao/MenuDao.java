package com.eriz.sys.dao;

import com.eriz.common.base.BaseDao;
import com.eriz.sys.domain.MenuDo;

import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
public interface MenuDao extends BaseDao<MenuDo> {

    List<MenuDo> findListByUserId(Long id);
}

