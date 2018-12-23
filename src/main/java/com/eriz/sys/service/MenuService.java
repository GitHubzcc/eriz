package com.eriz.sys.service;

import com.eriz.common.base.CoreService;
import com.eriz.common.domain.TreeDo;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.domain.UserDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@Service
public interface MenuService extends CoreService<MenuDo> {

    /**
     * 菜单树
     * @param id 用户id
     * @return tree
     */
    List<TreeDo<MenuDo>> findListByUserId(Long id);

    /**
     * 菜单树
     * @param keyValue 角色id
     * @return tree
     */
    List<Map<String,Object>> menuTree(Long keyValue);

    Set<String> findPermByUserId(Long id);
}
