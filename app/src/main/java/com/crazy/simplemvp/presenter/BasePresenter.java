package com.crazy.simplemvp.presenter;


import android.content.Context;
import android.content.Intent;

import com.crazy.simplemvp.controller.IBaseActivityController;

import java.util.UUID;

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
 * @param <V> 继承自 {@link IBaseActivityController.IView} 的工具
 */
public abstract class BasePresenter<V extends IBaseActivityController.IView> implements IBaseActivityController.IPresenter {

    protected V mView;
    protected Context mContext;

    public BasePresenter(V mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


    @Override
    public void onStop() {
    }

    /**
     * 获取意图
     *
     * @return
     */
    protected Intent getIntent() {
        return mView.getIntent();
    }

    /**
     * 关闭页面
     */
    protected void finish() {
        mView.finish();
    }

    /**
     * 跳转页面
     *
     * @param className 类名
     */
    protected void startActivity(Class className) {
        mView.startActivity(className);
    }

    /**
     * 跳转页面
     *
     * @param intent 意图
     */
    protected void startActivity(Intent intent) {
        mView.startActivity(intent);
    }

    protected void startActivity(Class className, String key, String str) {
        Intent intent = new Intent(mContext, className);
        intent.putExtra(key, str);
        mView.startActivity(intent);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
    }

    /**
     * 关闭页面
     */
    protected void finishResult(int resultCode) {
        mView.setResult(resultCode);
        mView.finish();
    }


    /**
     * 关闭页面
     */
    protected void finishResult(int resultCode, Intent data) {
        mView.setResult(resultCode, data);
        mView.finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


    public String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
