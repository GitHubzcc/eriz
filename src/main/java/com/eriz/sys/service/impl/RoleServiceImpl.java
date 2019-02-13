package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.RoleDao;
import com.eriz.sys.domain.RoleDO;
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
public class RoleServiceImpl extends CoreServiceImpl<RoleDao, RoleDO> implements RoleService {

    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String DEMO_CACHE_NAME = "demo";

    /**
     * @Cacheable注解
     * 使用ehcache缓存
     * 属性介绍：
     * value：如果value不写名称，则使用ehcache默认缓存配置方案
     * Key 属性：给存储的值起个名称。在查询时如果有名称相同的，那么则知己从缓存中将数据返回
     */
    @Override
    public List<RoleDO> userRole(Long uid) {

        if (uid != null) {
            return baseMapper.userRole(uid);
        }
        return baseMapper.selectList(null);
    }

    @Cacheable(value="role",key="#roleDO.roleName")
    @Override
    public List<RoleDO> all(RoleDO roleDO) {
        System.out.println("走缓存============================");
        return baseMapper.selAll(roleDO);
    }

    @Override
    public boolean insert(RoleDO roleDo) {
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
