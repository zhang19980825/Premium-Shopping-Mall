package com.zhangyang.model;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/22 17:46
 * 商品名称
 */
public class ProductType {
    private int id;
    private String producttypename;
    private String producttypedescription;
    private int  typegrade; //等级  比如1  2  3
    private int parentid; //如果是第一类别 父节点就为-1

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducttypename() {
        return producttypename;
    }

    public void setProducttypename(String producttypename) {
        this.producttypename = producttypename;
    }

    public String getProducttypedescription() {
        return producttypedescription;
    }

    public void setProducttypedescription(String producttypedescription) {
        this.producttypedescription = producttypedescription;
    }

    public int getTypegrade() {
        return typegrade;
    }

    public void setTypegrade(int typegrade) {
        this.typegrade = typegrade;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
}
