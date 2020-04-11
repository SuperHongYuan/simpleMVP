package com.crazy.simplemvp.bean.dao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;
import java.util.List;
import com.simpleMVP.greenDao.DaoSession;
import com.simpleMVP.greenDao.OrderGoodsTableDao;
import com.simpleMVP.greenDao.OrderTableDao;

/**
 *
 */
@Entity
public class OrderTable {

    @Id(autoincrement = true)
    public Long id;

    /**
     * 请求ID
     */
    @Unique
    public String requestID = "";
    /**
     * 订单ID
     */
    public String orderID = "";
    /**
     * 订单状态
     */
    public String orderState = "";
    /**
     * 订单金额
     */
    public Double orderMoney = 0.0;

    /**
     * 订单类型
     */
    public String orderType = "";

    /**
     * 备注
     */
    public String remark = "";

    /**
     * 会员ID
     */
    public String memberID = "";
    /**
     * 会员名称
     */
    public String memberName = "";
    /**
     * 会员号
     */
    public String leaguerCode = "";

    @ToMany(referencedJoinProperty = "orderID")
    List<OrderGoodsTable> goodsList;

    public String payID = "";
    public String payName = "";
    /**
     * 支付方式
     */
    public String orderNumber = "";//订单号

    public String payType = "";
    public Boolean payGiftIntegral = false;
    public String payState = "";

    public String payOrderID = "";
    public String payOrderNumber = "";
    public String payCode = "";
    public String wxOpenID = "";
    public String wxNickName = "";
    public String wxFaceCode = "";
    public String payMemberID = "";

    /**
     * 口令保存点
     */
    public String tokenValue = "";
    /**
     * 状态码
     * 0：成功，1：异常，2：异常已经处理
     */
    public int errorStatus = 1;

    /**
     * 创建时间
     */
    public Date createTime;

    /**
     * 结束时间
     */
    public Date endTime;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 771628697)
    private transient OrderTableDao myDao;


    @Generated(hash = 113940530)
    public OrderTable(Long id, String requestID, String orderID, String orderState,
            Double orderMoney, String orderType, String remark, String memberID,
            String memberName, String leaguerCode, String payID, String payName,
            String orderNumber, String payType, Boolean payGiftIntegral,
            String payState, String payOrderID, String payOrderNumber,
            String payCode, String wxOpenID, String wxNickName, String wxFaceCode,
            String payMemberID, String tokenValue, int errorStatus, Date createTime,
            Date endTime) {
        this.id = id;
        this.requestID = requestID;
        this.orderID = orderID;
        this.orderState = orderState;
        this.orderMoney = orderMoney;
        this.orderType = orderType;
        this.remark = remark;
        this.memberID = memberID;
        this.memberName = memberName;
        this.leaguerCode = leaguerCode;
        this.payID = payID;
        this.payName = payName;
        this.orderNumber = orderNumber;
        this.payType = payType;
        this.payGiftIntegral = payGiftIntegral;
        this.payState = payState;
        this.payOrderID = payOrderID;
        this.payOrderNumber = payOrderNumber;
        this.payCode = payCode;
        this.wxOpenID = wxOpenID;
        this.wxNickName = wxNickName;
        this.wxFaceCode = wxFaceCode;
        this.payMemberID = payMemberID;
        this.tokenValue = tokenValue;
        this.errorStatus = errorStatus;
        this.createTime = createTime;
        this.endTime = endTime;
    }

    @Generated(hash = 1330335826)
    public OrderTable() {
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Boolean getPayGiftIntegral() {
        return payGiftIntegral;
    }

    public void setPayGiftIntegral(Boolean payGiftIntegral) {
        this.payGiftIntegral = payGiftIntegral;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getPayOrderID() {
        return payOrderID;
    }

    public void setPayOrderID(String payOrderID) {
        this.payOrderID = payOrderID;
    }

    public String getPayOrderNumber() {
        return payOrderNumber;
    }

    public void setPayOrderNumber(String payOrderNumber) {
        this.payOrderNumber = payOrderNumber;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getWxOpenID() {
        return wxOpenID;
    }

    public void setWxOpenID(String wxOpenID) {
        this.wxOpenID = wxOpenID;
    }

    public String getWxFaceCode() {
        return wxFaceCode;
    }

    public void setWxFaceCode(String wxFaceCode) {
        this.wxFaceCode = wxFaceCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getRequestID() {
        return this.requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }


    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayMemberID() {
        return payMemberID;
    }

    public void setPayMemberID(String payMemberID) {
        this.payMemberID = payMemberID;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getWxNickName() {
        return this.wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "id=" + id +
                ", requestID='" + requestID + '\'' +
                ", orderID='" + orderID + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderMoney=" + orderMoney +
                ", orderType='" + orderType + '\'' +
                ", remark='" + remark + '\'' +
                ", memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                ", goodsList=" + goodsList +
                ", payID='" + payID + '\'' +
                ", payName='" + payName + '\'' +
                ", payType='" + payType + '\'' +
                ", payGiftIntegral=" + payGiftIntegral +
                ", payState='" + payState + '\'' +
                ", payOrderID='" + payOrderID + '\'' +
                ", payOrderNumber='" + payOrderNumber + '\'' +
                ", payCode='" + payCode + '\'' +
                ", wxOpenID='" + wxOpenID + '\'' +
                ", wxNickName='" + wxNickName + '\'' +
                ", wxFaceCode='" + wxFaceCode + '\'' +
                ", payMemberID='" + payMemberID + '\'' +
                ", errorStatus=" + errorStatus +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                '}';
    }

    public String getTokenValue() {
        return this.tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getLeaguerCode() {
        return this.leaguerCode;
    }

    public void setLeaguerCode(String leaguerCode) {
        this.leaguerCode = leaguerCode;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1853321778)
    public List<OrderGoodsTable> getGoodsList() {
        if (goodsList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrderGoodsTableDao targetDao = daoSession.getOrderGoodsTableDao();
            List<OrderGoodsTable> goodsListNew = targetDao._queryOrderTable_GoodsList(orderID);
            synchronized (this) {
                if (goodsList == null) {
                    goodsList = goodsListNew;
                }
            }
        }
        return goodsList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1218049045)
    public synchronized void resetGoodsList() {
        goodsList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1710502797)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderTableDao() : null;
    }
}
