package com.eriz.module.domain;

import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eriz.common.base.BaseDo;


/**
 * 
 * <pre>
 * 图书表
 * </pre>
 * <small> 2019-01-04 10:36:42 | eriz</small>
 */
@SuppressWarnings("serial")
@TableName("module_book")
public class ModuleBookDO extends BaseDo {
	@TableId
	private Long id;

    /** 书名 */
    private String name;

    /** 备注 */
    private String remark;

    /** 价格 */
    private BigDecimal price;

    /** 创建时间 */
    private Date createtime;

}
