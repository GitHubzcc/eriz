package com.eriz.sys.service;

import com.eriz.common.base.CoreService;
import com.eriz.sys.domain.DeptDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月13日 | eriz</small>
 */
@Service
public interface DeptService extends CoreService<DeptDo> {

    List<Map<String,Object>> deptTree();
}
