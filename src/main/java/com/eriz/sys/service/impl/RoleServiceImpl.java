package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.RoleDao;
import com.eriz.sys.domain.RoleDo;
import com.eriz.sys.domain.RoleMenuDo;
import com.eriz.sys.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月13日 | eriz</small>
 */
@Transactional
@Service("sysRoleServiceImpl")
public class RoleServiceImpl extends CoreServiceImpl<RoleDao, RoleDo> implements RoleService {

    @Override
    public List<RoleDo> userRole(Long uid) {
        if (uid != null) {
            return baseMapper.userRole(uid);
        }
        return baseMapper.selectList(null);
    }

    @Override
    public boolean insert(RoleDo roleDo) {
        //更新
        if (roleDo != null && roleDo.getId() != null) {
            baseMapper.updateById(roleDo);
        } else {
            baseMapper.insert(roleDo);
        }
        Long rid = roleDo.getId();
        List<Long> mids = roleDo.getMenuIds();
        List<RoleMenuDo> list = new ArrayList<>();
        if (rid != null) {
            for (Long mid : mids) {
                RoleMenuDo r = new RoleMenuDo();
                r.setRoleId(rid);
                r.setMenuId(mid);
                list.add(r);
            }
            baseMapper.deleteRoleMenu(rid);
            baseMapper.insertRoleMenu(list);
            return true;
        }
        return false;
    }
}
