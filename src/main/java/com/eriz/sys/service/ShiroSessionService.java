package com.eriz.sys.service;

import com.eriz.sys.domain.OnlineDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShiroSessionService {

    List<OnlineDO> list();

    boolean removeSession(List<String> list);
}
