package com.crazy.simplemvp.view.activity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.crazy.simplemvp.R;
import com.crazy.simplemvp.controller.IMainController;

import butterknife.BindView;

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
public class MainActivity extends BaseActivity<IMainController.IPresenter> implements IMainController.IView {

    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.root_layout)
    ConstraintLayout rootLayout;

    @NonNull
    @Override
    protected View getRootLayout() {
        return rootLayout;
    }

    @Override
    protected IMainController.IPresenter initPresenter() {
        return null;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected int setContentLayout() {
        return R.layout.activity_main;
    }

}
