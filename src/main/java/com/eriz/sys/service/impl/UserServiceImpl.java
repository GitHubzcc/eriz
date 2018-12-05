package com.eriz.sys.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.sys.dao.UserDao;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
