package com.crazy.simplemvp.controller;

import android.content.Intent;

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
 * 所有页面的控制器
 */
public interface IBaseActivityController extends IController{
    /**
     * 基础View应有的方法 覆盖activity常用方法，开放到presenter调用
     */
    interface IView extends IController.IView{

        Intent getIntent();

        void startActivity(Class className);
        void startActivity(Intent intent);
        void startActivityForResult(Class className, int requestCode);
        void startActivityForResult(Intent intent, int requestCode);
        void showTips(String msg);
        void setResult(int resultCode, Intent data);
        void setResult(int resultCode);
    }

    /**
     * 基础Presenter 应有的方法 应当绑定Activity生命周期
     */
    interface IPresenter extends IController.IPresenter{


        void onStop();

        void onStart();

        void onPause();

        void onResume();

        void onDestroy();

        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
