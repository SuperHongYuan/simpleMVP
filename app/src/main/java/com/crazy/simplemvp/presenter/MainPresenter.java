package com.crazy.simplemvp.presenter;

import android.content.Context;

import com.crazy.simplemvp.controller.IBaseActivityController;
import com.crazy.simplemvp.controller.IMainController;
import com.crazy.simplemvp.utils.XLog;

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MainPresenter
 * Author: huang
 * Date: 2020/4/11 19:22
 * Description:
 * History:
 * 作者：<author>
 * 修改时间：<time>
 * 版本：<version>
 * If the implementation is hard to explain, it's a bad idea.
 * If the implementation is easy to explain, it may be a good idea.
 */
public class MainPresenter extends BasePresenter<IMainController.IView> implements IMainController.IPresenter {

    public MainPresenter(IMainController.IView mView, Context mContext) {
        super(mView, mContext);
    }

    @Override
    public void onStart() {
        super.onStart();
        XLog.d("MainPresenter onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        XLog.d("MainPresenter onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        XLog.d("MainPresenter onResume");

    }

    @Override
    public void onStop() {
        super.onStop();
        XLog.d("MainPresenter onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.d("MainPresenter onDestroy");

    }


    @Override
    public void print(String msg) {
        XLog.d("msg");
        mView.showTips(msg);
    }
}
