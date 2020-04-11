package com.crazy.simplemvp.model;

import android.content.Context;

import com.crazy.simplemvp.bean.response.BaseResult;
import com.crazy.simplemvp.view.dialog.LoadingDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
 * @param <T> 继承自 {@link BaseResult} 的数据类
 */
public abstract class BaseResultObserver<T extends BaseResult> implements Observer<T> {


    private Disposable disposable;
    private LoadingDialog loadingDialog;
    private Context mContext;

    public BaseResultObserver(Context mContext) {
        this.mContext = mContext;
        loadingDialog = LoadingDialog.getInstance(mContext);
    }

    public BaseResultObserver(Context mContext, boolean isLogin) {
        this.mContext = mContext;
        if (isLogin) {
            loadingDialog = LoadingDialog.getInstance(mContext);
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
        onSubscribeListener();
    }

    @Override
    public void onNext(T t) {
        if (mContext != null) onSucceedListener(t);
       /* if ("401".equals(t.getResponseStatus().getErrorCode())) {
            EventBusUtils.post(new MessageEvent(Constants.ActivityLabel.RE_REGISTER_EQUIPMENT_MAIN));
            throw new NullPointerException(t.getResponseStatus().getMessage());
        }*/
    }

    @Override
    public void onError(Throwable e) {
        if (mContext != null) onError(e, true);
    }

    public void onError(Throwable e, boolean isListener) {
        if (isListener) onErrorListener("报错：" + e.getMessage());
        if (loadingDialog != null)
            loadingDialog.dismissLoadingDialog();
        if (disposable != null)
            disposable.dispose();
    }

    /**
     * 错误事件
     *
     * @param e
     */
    public abstract void onErrorListener(String e);

    /**
     * 回调成功事件
     */
    public abstract void onSucceedListener(T t);

    /**
     * 请求开始时
     */
    public void onSubscribeListener() {
        showLoadingDialog("Loading...");
    }

    public void showLoadingDialog(String mag) {
        if (loadingDialog != null)
            loadingDialog.showLoadingDialog(mag);
    }

    /**
     * 请求完成
     */
    public void onCompleteListener() {
    }

    @Override
    public void onComplete() {
        if (loadingDialog != null)
            loadingDialog.dismissLoadingDialog();
        onCompleteListener();
        if (disposable != null)
            disposable.dispose();
    }
}
