package com.crazy.simplemvp.presenter;

import android.content.Context;

import com.crazy.simplemvp.controller.IBaseActivityController;
import com.crazy.simplemvp.controller.IMainController;

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
}
