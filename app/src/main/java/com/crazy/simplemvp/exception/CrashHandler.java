package com.crazy.simplemvp.exception;

import com.crazy.simplemvp.utils.XLog;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        XLog.e("程序闪退", throwable);
        //退出程序
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
