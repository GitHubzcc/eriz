package com.eriz.sys.dao;

import com.eriz.common.base.BaseDao;
import com.eriz.sys.domain.DeptDo;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月13日 | eriz</small>
 */
public interface DeptDao extends BaseDao<DeptDo> {
    List<Map<String,Object>> deptTree();
}

