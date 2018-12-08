package com.eriz.sys.service;

import com.eriz.common.base.CoreService;
import com.eriz.common.domain.TreeDo;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.domain.UserDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@Service
public interface MenuService extends CoreService<MenuDo> {

    List<TreeDo<MenuDo>> findListByUserId(Long id);
}
