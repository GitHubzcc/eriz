package com.eriz.common.base;

import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.util.WebUtil;
import org.apache.commons.lang.StringUtils;

public abstract class SysController {

    public <T> Page<T> getPage(Class<T> c) {
        int pageNumber = getPageParame("page", 1);
        int pageSize = getPageParame("limit", 10);
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
