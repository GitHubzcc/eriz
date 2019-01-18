package com.eriz.common.service;

import com.eriz.common.base.CoreService;
import com.eriz.common.domain.ConfigDO;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年12月6日 | eriz</small>
 */
public interface ConfigService extends CoreService<ConfigDO> {
    ConfigDO getByKey(String k);

    String getValueByKey(String k);
    
    void updateKV(Map<String, String> kv);
    
    List<ConfigDO> findListByKvType(int kvType);
}
