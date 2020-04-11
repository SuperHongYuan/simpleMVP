package com.crazy.simplemvp.bean.response;

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: App
 * Author: huang
 * Date: 2020/4/11 15:03
 * Description:
 * History:
 * 作者：<author>
 * 修改时间：<time>
 * 版本：<version>
 * If the implementation is hard to explain, it's a bad idea.
 * If the implementation is easy to explain, it may be a good idea.
 *
 * 注册接口
 */
public class RegisterEntity {

    /**
     * AppID : 72520
     * AppKey : jtsxsC1wzs
     * TerminalName : xpwrBFCFeT
     * TS : 77195
     */

    private String AppID;
    private String AppKey;
    private String TerminalName;
    private String TerminalID;
    private long TS;

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String AppID) {
        this.AppID = AppID;
    }

    public String getAppKey() {
        return AppKey;
    }

    public void setAppKey(String AppKey) {
        this.AppKey = AppKey;
    }

    public String getTerminalName() {
        return TerminalName;
    }

    public void setTerminalName(String TerminalName) {
        this.TerminalName = TerminalName;
    }

    public long getTS() {
        return TS;
    }

    public void setTS(long TS) {
        this.TS = TS;
    }

    public String getTerminalID() {
        return TerminalID;
    }

    public void setTerminalID(String terminalID) {
        TerminalID = terminalID;
    }

    @Override
    public String toString() {
        return "RegisterEntity{" +
                "AppID='" + AppID + '\'' +
                ", AppKey='" + AppKey + '\'' +
                ", TerminalName='" + TerminalName + '\'' +
                ", TerminalID='" + TerminalID + '\'' +
                ", TS=" + TS +
                '}';
    }
}
