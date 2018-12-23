package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.UserDao;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.domain.UserRoleDo;
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
public class UserServiceImpl extends CoreServiceImpl<UserDao, UserDo> implements UserService {

    @Override
    public boolean exist(Map<String, Object> params) {
        return retBool(baseMapper.selectByMap(params).size());
    }


    @Override
    public boolean insert(UserDo userDo) {
        int count = baseMapper.insert(userDo);
        Long uId = userDo.getId();
        if (count > 0 && uId != null) {
            baseMapper.removeUserRole(uId);
            List<Long> roles = userDo.getRoleIds();
            List<UserRoleDo> list = new ArrayList<>();
            for (Long id : roles) {
                UserRoleDo u = new UserRoleDo();
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
