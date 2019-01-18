package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.DeptDao;
import com.eriz.sys.domain.DeptDO;
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
@Transactional(rollbackFor = Exception.class)
@Service("sysDeptServiceImpl")
public class DeptServiceImpl extends CoreServiceImpl<DeptDao, DeptDO> implements DeptService {

    @Override
    public List<Map<String, Object>> deptTree() {
        return baseMapper.deptTree();
    }

    @Override
    public boolean insert(DeptDO deptDO) {
        if (deptDO != null && deptDO.getId() != null) {
            baseMapper.updateById(deptDO);
        }
        if (deptDO != null && deptDO.getParentId() == null) {
            deptDO.setParentId(0L);
            super.insert(deptDO);
        }
        return true;
    }
}
