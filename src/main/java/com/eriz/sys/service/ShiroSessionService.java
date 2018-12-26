package com.eriz.sys.service;

import com.eriz.sys.domain.OnlineDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShiroSessionService {

    List<OnlineDo> list();

    boolean removeSession(List<String> list);
}
