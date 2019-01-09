package com.eriz.common.base;

import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.util.ShiroUtils;
import com.eriz.common.util.WebUtil;
import com.eriz.sys.domain.UserDo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2018年12月17日 | eriz
 * 系统层控制层
 */
public abstract class SysController {

    public final static Logger log = LoggerFactory.getLogger(SysController.class);

    public UserDo getUser(){
        return ShiroUtils.getSysUser();
    }

    public <T> Page<T> getPage(Class<T> c) {
        int pageNumber = getPageParame("page", 1);
        int pageSize = getPageParame("limit", 10);
        log.info("分页参数：page=" + pageNumber + ",limit=" + pageSize);
        Page<T> page = new Page<>(pageNumber, pageSize);
        String sort = WebUtil.getParameter("sort");
        if (StringUtils.isNotBlank(sort)) {
            page.setOrderByField(sort);
            String order = WebUtil.getParameter("order");
            if (StringUtils.isNotBlank(order)) {
                page.setAsc("asc".equalsIgnoreCase(order));
            }
        }
        return page;
    }

    private int getPageParame(String keyword, int defalut) {
        String parame = WebUtil.getParameter(keyword);
        if (StringUtils.isBlank(parame)) {
            return defalut;
        }
        return Integer.parseInt(parame);
    }
}
