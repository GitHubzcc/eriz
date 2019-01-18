package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.RoleDao;
import com.eriz.sys.domain.RoleDo;
import com.eriz.sys.domain.RoleMenuDO;
import com.eriz.sys.service.RoleService;
import org.springframework.cache.annotation.Cacheable;
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

    /**
     * 缓存的key
     */
    public static final String THING_ALL_KEY   = "\"thing_all\"";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "demo";

    @Cacheable(value = DEMO_CACHE_NAME, key = THING_ALL_KEY)
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
        List<RoleMenuDO> list = new ArrayList<>();
        if (rid != null) {
            for (Long mid : mids) {
                RoleMenuDO r = new RoleMenuDO();
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
