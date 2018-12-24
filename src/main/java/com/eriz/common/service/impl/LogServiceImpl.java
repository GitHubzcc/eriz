package com.eriz.common.service.impl;

import com.eriz.common.base.CoreServiceImpl;
import com.eriz.common.dao.LogDao;
import com.eriz.common.domain.LogDo;
import com.eriz.common.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月23日 | eriz</small>
 */
@Transactional
@Service("LogServiceImpl")
public class LogServiceImpl extends CoreServiceImpl<LogDao, LogDo> implements LogService {

}
