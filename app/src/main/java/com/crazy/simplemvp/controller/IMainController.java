package com.crazy.simplemvp.controller;

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: IMainActivity
 * Author: huang
 * Date: 2020/4/11 19:19
 * Description:
 * History:
 * 作者：<author>
 * 修改时间：<time>
 * 版本：<version>
 * If the implementation is hard to explain, it's a bad idea.
 * If the implementation is easy to explain, it may be a good idea.
 */
public interface IMainController extends IBaseActivityController {

    interface IPresenter extends IBaseActivityController.IPresenter {
        /**
         * @param msg 打印的消息
         */
        void print(String msg);
    }
}
