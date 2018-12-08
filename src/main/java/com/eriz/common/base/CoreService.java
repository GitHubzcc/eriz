package com.eriz.common.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 通用业务层实现
 * </pre>
 * 
 * <small> 2018年12月5日 | eriz</small>
 * 
 * @param <T>
 */
public interface CoreService<T> extends IService<T> {
    List<T> findByKv(Object... param);

    T findOneByKv(Object... param);

    Map<String, Object> convertToMap(Object... param);

    EntityWrapper<T> convertToEntityWrapper(Object... params);

}
