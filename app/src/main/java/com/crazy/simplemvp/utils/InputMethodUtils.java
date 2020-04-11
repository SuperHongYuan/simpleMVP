package com.crazy.simplemvp.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

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
 * 输入法工具
 */
public class InputMethodUtils {
	/**
	 * 关闭输入键盘
	 * 
	 * @param context
	 */
	public static void closeInputKeyboard(Context context) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		View focusView = ((Activity) context).getCurrentFocus();
		if (focusView != null) {
			imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
		}
	}

	/**
	 * 弹出输入法
	 * 
	 * @param context
	 * @param remindView
	 */
	public static void showInputKeyBord(Context context, View remindView) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (remindView != null) {
			remindView.requestFocus();
			imm.showSoftInput(remindView, 0);
		}
	}
}
