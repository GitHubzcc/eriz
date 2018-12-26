package com.eriz.sys.service.impl;

import com.eriz.sys.domain.OnlineDo;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.ShiroSessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ShiroSessionServiceImpl implements ShiroSessionService {

    @Autowired
    private SessionDAO sessionDAO;


    @Override
    public List<OnlineDo> list() {
        //数据量大时通过 page分页
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        List<OnlineDo> list = new ArrayList<>();
        for (Session session : sessions) {
            if (session == null) continue;
            OnlineDo onlineDo = new OnlineDo();
            UserDo userDo = new UserDo();
            //principalCollection 身份集合
            SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                continue;
            } else {
                principalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                userDo = (UserDo) principalCollection.getPrimaryPrincipal();
                onlineDo.setUsername(userDo.getUsername());
            }
            onlineDo.setId(session.getId().toString());
            onlineDo.setHost(session.getHost());
            onlineDo.setLastAccessTime(session.getLastAccessTime());
            onlineDo.setStartTimestamp(session.getStartTimestamp());
            onlineDo.setTimeout(session.getTimeout());
            list.add(onlineDo);
        }
        return list;
    }

    @Override
    public boolean removeSession(List<String> ids) {
        //read session by id
        for (String str : ids) {
            Session session = sessionDAO.readSession(str);
            sessionDAO.delete(session);
        }
        return true;
    }
}
