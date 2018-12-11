package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.domain.TreeDo;
import com.eriz.common.util.BuildTree;
import com.eriz.sys.dao.MenuDao;
import com.eriz.sys.dao.UserDao;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.MenuService;
import com.eriz.sys.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
