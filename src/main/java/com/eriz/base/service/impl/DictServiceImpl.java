package com.eriz.base.service.impl;

import com.eriz.base.dao.DictDao;
import com.eriz.base.domain.DictDo;
import com.eriz.base.service.DictService;
import com.eriz.common.base.CoreServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月17日 | eriz</small>
 */
@Transactional
@Service("baseDictServiceImpl")
public class DictServiceImpl extends CoreServiceImpl<DictDao, DictDo> implements DictService {

    @Override
    public boolean insert(DictDo dictDo) {
        if (dictDo != null && dictDo.getId() != null) {
            baseMapper.updateById(dictDo);
        } else {
            super.insert(dictDo);
        }
        return true;
    }
}
