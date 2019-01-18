package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.domain.TreeDO;
import com.eriz.common.util.BuildTree;
import com.eriz.sys.dao.MenuDao;
import com.eriz.sys.domain.MenuDO;
import com.eriz.sys.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@Transactional
@Service("sysMenuServiceImpl")
public class MenuServiceImpl extends CoreServiceImpl<MenuDao, MenuDO> implements MenuService {

    @Override
    public List<TreeDO<MenuDO>> findListByUserId(Long id) {
        List<MenuDO> list = baseMapper.findListByUserId(id);
        List<TreeDO<MenuDO>> listTree = new ArrayList<>();
        for (MenuDO menuDO : list) {
            TreeDO<MenuDO> treeDo = new TreeDO<>();
            treeDo.setId(menuDO.getId().toString());
            treeDo.setParentId(menuDO.getParentId().toString());
            treeDo.setText(menuDO.getName());
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("icon", menuDO.getIcon());
            attributes.put("url", menuDO.getUrl());
            treeDo.setAttributes(attributes);
            listTree.add(treeDo);
        }
        return BuildTree.buildList(listTree, "0");
    }

    @Override
    public List<Map<String, Object>> menuTree(Long keyValue) {
        if (keyValue != null) {
            return baseMapper.menuTreeRid(keyValue);
        }
        return baseMapper.menuTree();
    }

    @Override
    public Set<String> findPermByUserId(Long id) {
        List<String> list = baseMapper.findPermByUserId(id);
        Set<String> set = new HashSet<>();
        for (String perm : list) {
            if (StringUtils.isNotBlank(perm)) {
                set.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return set;
    }

    @Override
    public boolean insert(MenuDO menuDO) {
        if (menuDO != null && menuDO.getId() != null) {
            baseMapper.updateById(menuDO);
        } else {
            baseMapper.insert(menuDO);
        }
        return true;
    }
}
