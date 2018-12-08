package com.eriz.common.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.dao.ConfigDao;
import com.eriz.common.domain.ConfigDo;
import com.eriz.common.service.ConfigService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月6日 | eriz</small>
 */
@Service
public class ConfigServiceImpl extends CoreServiceImpl<ConfigDao, ConfigDo> implements ConfigService {
    
    @Override
    public ConfigDo getByKey(String k) {
        ConfigDo entity = new ConfigDo();
        entity.setK(k);
        return baseMapper.selectOne(entity);
    }
    
    @Override
    public String getValueByKey(String k) {
        ConfigDo bean = this.getByKey(k);
        return bean == null ? "" : bean.getV();
    }
    
    @Override
    public void updateKV(Map<String, String> kv) {
        for(Map.Entry<String, String> entry : kv.entrySet()){
            ConfigDo config = this.getByKey(entry.getKey());
            config.setV(entry.getValue());
            super.updateById(config);
        }
    }
    
    @Override
    public List<ConfigDo> findListByKvType(int kvType){
        ConfigDo configDo = new ConfigDo();
        configDo.setKvType(kvType);
        EntityWrapper<ConfigDo> ew = new EntityWrapper<>(configDo);
        List<ConfigDo> list = super.selectList(ew);
        return list;
    }
    
    
}
