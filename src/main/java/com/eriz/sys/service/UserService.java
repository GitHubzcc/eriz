package com.eriz.sys.service;

import com.eriz.common.base.CoreService;
import com.eriz.sys.domain.UserDO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@Service
public interface UserService extends CoreService<UserDO> {

    boolean exist(Map<String, Object> params);
}
