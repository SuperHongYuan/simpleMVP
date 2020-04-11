package com.crazy.simplemvp.bean.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

@Entity
public class OrderGoodsTable {

    @Id(autoincrement = true)
    public Long id;
    /**
     * 订单ID
     */
    public String orderID;
    /**
     * 商品ID
     */
    public String goodsID;
    /**
     * 商品名称
     */
    public String goodsName;
    /**
     * 商品金额
     */
    public Double goodsMoney;
    /**
     * 商品数量
     */
    public Double goodsNumber;

    public Date createDate;

    public Date endDate;

    @Generated(hash = 1165406490)
    public OrderGoodsTable(Long id, String orderID, String goodsID,
            String goodsName, Double goodsMoney, Double goodsNumber,
            Date createDate, Date endDate) {
        this.id = id;
        this.orderID = orderID;
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsMoney = goodsMoney;
        this.goodsNumber = goodsNumber;
        this.createDate = createDate;
        this.endDate = endDate;
    }

    @Generated(hash = 1846164728)
    public OrderGoodsTable() {
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(Double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public Double getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Double goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "OrderGoodsTable{" +
                "id='" + id + '\'' +
                ", orderID='" + orderID + '\'' +
                ", goodsID='" + goodsID + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsMoney=" + goodsMoney +
                ", goodsNumber=" + goodsNumber +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                '}';
    }
}
