package com.zhangyang.model;

import java.util.Date;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 10:53
 * 商品信息表
 */
public class Product {
    private int id;
    private int producttypeid;  //商品类别
    private String producttitle;  //商品标题
    private int productprice;
    private int mechartid;  //商家id
    private Date creattime; //创建时间
    private Date audittime;  //审核时间
    private int auditstate;  //审核状态  0代表未审核   1 审核通过  2 审核不通过
    private int stocknum;  //库存
    private int sellnum;   //销售数量
    private String productpicurl;
    private int productstatus; //商品状态  0代表上架  1代表下架

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(int producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    public int getMechartid() {
        return mechartid;
    }

    public void setMechartid(int mechartid) {
        this.mechartid = mechartid;
    }



    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public int getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(int auditstate) {
        this.auditstate = auditstate;
    }

    public int getStocknum() {
        return stocknum;
    }

    public void setStocknum(int stocknum) {
        this.stocknum = stocknum;
    }

    public int getSellnum() {
        return sellnum;
    }

    public void setSellnum(int sellnum) {
        this.sellnum = sellnum;
    }

    public String getProductpicurl() {
        return productpicurl;
    }

    public void setProductpicurl(String productpicurl) {
        this.productpicurl = productpicurl;
    }

    public int getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(int productstatus) {
        this.productstatus = productstatus;
    }
}
