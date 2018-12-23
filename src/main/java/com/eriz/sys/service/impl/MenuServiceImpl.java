package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.domain.TreeDo;
import com.eriz.common.util.BuildTree;
import com.eriz.sys.dao.MenuDao;
import com.eriz.sys.domain.MenuDo;
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
public class MenuServiceImpl extends CoreServiceImpl<MenuDao, MenuDo> implements MenuService {

    @Override
    public List<TreeDo<MenuDo>> findListByUserId(Long id) {
        List<MenuDo> list = baseMapper.findListByUserId(id);
        List<TreeDo<MenuDo>> listTree = new ArrayList<>();
        for (MenuDo menuDo : list) {
            TreeDo<MenuDo> treeDo = new TreeDo<>();
            treeDo.setId(menuDo.getId().toString());
            treeDo.setParentId(menuDo.getParentId().toString());
            treeDo.setText(menuDo.getName());
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("icon", menuDo.getIcon());
            attributes.put("url", menuDo.getUrl());
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
    public boolean insert(MenuDo menuDo) {
        if (menuDo != null && menuDo.getId() != null) {
            baseMapper.updateById(menuDo);
        } else {
            baseMapper.insert(menuDo);
        }
        return true;
    }
}
