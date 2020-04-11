package com.crazy.simplemvp;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.crazy.simplemvp.exception.CrashHandler;
import com.crazy.simplemvp.utils.SpUtil;
import com.simpleMVP.greenDao.DaoMaster;
import com.simpleMVP.greenDao.DaoSession;

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
 */
public class App extends Application {

    private static App mContext;
    private DaoSession daoSession;

    public static App getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
        SpUtil.init(mContext);
        initGreenDao();
        initData();
    }

    private void initData() {

    }

    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "SimpleMVP.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
}
