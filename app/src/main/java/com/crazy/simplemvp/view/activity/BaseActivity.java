package com.crazy.simplemvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.crazy.simplemvp.R;
import com.crazy.simplemvp.controller.IBaseActivityController;
import com.crazy.simplemvp.utils.EventBusUtils;
import com.google.android.material.snackbar.Snackbar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

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
 * @param <T> Activity所对应的Presenter
 */
public abstract class BaseActivity<T extends IBaseActivityController.IPresenter> extends AppCompatActivity implements IBaseActivityController.IView {

    private Unbinder mUnbinder;
    View rootLayout;
    protected Context mContext;
    protected T mPresenter;

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null)
            mPresenter.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null)
            mPresenter.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null)
            mPresenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null)
            mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        if (EventBusUtils.isRegistered(this)) {
            EventBusUtils.unregister(this);
        }
        if (mUnbinder != null)
            mUnbinder.unbind();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initSystemData();
        setContentView(setContentLayout());
        mContext = this;
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mPresenter = initPresenter();
        rootLayout = getRootLayout();
        initData();
        initEvent();
    }


    /**
     * 获得根布局
     *
     * @return 根布局
     */
    @NonNull
    protected abstract View getRootLayout();

    /**
     * 获得 Presenter
     *
     * @return Presenter
     */
    protected abstract T initPresenter();

    /**
     * 根据 class 直接跳转 Activity
     *
     * @param className class文件 X.class
     */
    @Override
    public void startActivity(Class className) {
        Intent intent = new Intent(mContext, className);
        startActivity(intent);
    }

    public void startActivity(Class className, String key, String str) {
        Intent intent = new Intent(mContext, className);
        intent.putExtra(key, str);
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Class className, int requestCode) {
        Intent intent = new Intent(mContext, className);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 初始化系统参数，在页面初始化之前
     */
    protected void initSystemData() {
    }

    /**
     * 初始化页面参数，在界面初始化之后
     */
    protected abstract void initData();

    /**
     * 返回当前页面布局文件
     *
     * @return @LayoutRes R.layout.x
     */
    @LayoutRes
    protected abstract int setContentLayout();

    /**
     * 事件集
     */
    protected void initEvent() {
    }


    /**
     * 显示提示
     *
     * @param msg
     */
    @Override
    public void showTips(String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (rootLayout != null)
                    Snackbar.make(rootLayout, msg, Snackbar.LENGTH_LONG)
                            .setActionTextColor(getColor(R.color.colorAccent))
                            .setAction("确定", null)
                            .show();
            }
        });
    }


    /**
     * 显示提示
     *
     * @param msg
     */
    public void showTips(String msg, View.OnClickListener listener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (rootLayout != null)
                    Snackbar.make(rootLayout, msg, Snackbar.LENGTH_LONG)
                            .setActionTextColor(getColor(R.color.colorAccent))
                            .setAction("确定", listener)
                            .show();
            }
        });
    }


}
