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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ModuleBookDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", price=" + price +
                ", createtime=" + createtime +
                '}';
    }
}
