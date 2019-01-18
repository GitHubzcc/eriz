package com.eriz.common.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.dao.ConfigDao;
import com.eriz.common.domain.ConfigDO;
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
public class ConfigServiceImpl extends CoreServiceImpl<ConfigDao, ConfigDO> implements ConfigService {

    /**
     * 通过k值模糊查询
     * @param k 值
     * @return 模糊结果
     */
    @Override
    public ConfigDO getByKey(String k) {
        ConfigDO entity = new ConfigDO();
        entity.setK(k);
        return baseMapper.selectOne(entity);
    }
    
    @Override
    public String getValueByKey(String k) {
        ConfigDO bean = this.getByKey(k);
        return bean == null ? "" : bean.getV();
    }
    
    @Override
    public void updateKV(Map<String, String> kv) {
        for(Map.Entry<String, String> entry : kv.entrySet()){
            ConfigDO config = this.getByKey(entry.getKey());
            config.setV(entry.getValue());
            super.updateById(config);
        }
    }
    
    @Override
    public List<ConfigDO> findListByKvType(int kvType){
        ConfigDO configDo = new ConfigDO();
        configDo.setKvType(kvType);
        EntityWrapper<ConfigDO> ew = new EntityWrapper<>(configDo);
        List<ConfigDO> list = super.selectList(ew);
        return list;
    }
    
    
}
