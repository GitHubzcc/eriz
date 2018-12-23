package com.eriz.sys.service;

import com.eriz.common.base.CoreService;
import com.eriz.sys.domain.RoleDo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@Service
public interface RoleService extends CoreService<RoleDo> {

    List<RoleDo> userRole(Long uid);
}
