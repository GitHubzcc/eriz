package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.DeptDao;
import com.eriz.sys.domain.DeptDo;
import com.eriz.sys.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月13日 | eriz</small>
 */
@Transactional
@Service("sysDeptServiceImpl")
public class DeptServiceImpl extends CoreServiceImpl<DeptDao, DeptDo> implements DeptService {

    @Override
    public List<Map<String, Object>> deptTree() {
        return baseMapper.deptTree();
    }

    @Override
    public boolean insert(DeptDo deptDo) {
        if (deptDo != null && deptDo.getId() != null) {
            baseMapper.updateById(deptDo);
        }
        if (deptDo != null && deptDo.getParentId() == null) {
            deptDo.setParentId(0L);
            super.insert(deptDo);
        }
        return true;
    }
}
