package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.UserDao;
import com.eriz.sys.domain.UserDO;
import com.eriz.sys.domain.UserRoleDO;
import com.eriz.sys.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@Transactional
@Service("sysUserServiceImpl")
public class UserServiceImpl extends CoreServiceImpl<UserDao, UserDO> implements UserService {

    @Override
    public boolean exist(Map<String, Object> params) {
        return retBool(baseMapper.selectByMap(params).size());
    }


    @Override
    public boolean insert(UserDO userDo) {
        int count = baseMapper.insert(userDo);
        Long uId = userDo.getId();
        if (count > 0 && uId != null) {
            baseMapper.removeUserRole(uId);
            List<Long> roles = userDo.getRoleIds();
            List<UserRoleDO> list = new ArrayList<>();
            for (Long id : roles) {
                UserRoleDO u = new UserRoleDO();
                u.setUserId(uId);
                u.setRoleId(id);
                list.add(u);
            }
            baseMapper.insertUserRole(list);
            return true;
        }
        return false;
    }
}
