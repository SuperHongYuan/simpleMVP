package com.crazy.simplemvp.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.crazy.simplemvp.R;

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
 * 默认的加载进度条
 */
public class LoadingDialog {

    private Context mContext;
    private static LoadingDialog loadingDialog = null;
    private Dialog dialog;
    private TextView tvLoading;

    private LoadingDialog(Context mContext) {
        this.mContext = mContext;
    }

    public static LoadingDialog getInstance(@NonNull Context mContext) {
        if (loadingDialog == null) {
            return new LoadingDialog(mContext);
        } else {
            return loadingDialog;
        }
    }

    /**
     * 展示加载框
     */
    public void showLoadingDialog() {
        showLoadingDialog("loading...");
    }


    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /**
     * 展示加载框
     */
    public void showLoadingDialog(String msg) {
        try {
            if (isMainThread()) {
                if (dialog != null && dialog.isShowing())
                    return;
                dialog = new Dialog(mContext, R.style.Dialog);
                View view = View.inflate(mContext, R.layout.dialog_loading, null);
//                ProgressBar pbLoading = view.findViewById(R.id.pb_loading);
                ImageView imageView = view.findViewById(R.id.iv_loading);
                Glide.with(mContext)
                        .asGif()
                        .fitCenter()
                        .skipMemoryCache(true) // 不使用内存缓存
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .load(R.mipmap.ic_gif_loading)
                        .into(imageView);
                tvLoading = view.findViewById(R.id.tv_loading);
                dialog.setContentView(view);
                tvLoading.setText(msg);
//            dialog.setMessage(msg);
//            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
                dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
                dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLoadMsg(String msg) {
        tvLoading.setText(msg);
    }

    /**
     * 关闭加载框
     */
    public void dismissLoadingDialog() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.cancel();
                dialog.dismiss();
            }
            loadingDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
