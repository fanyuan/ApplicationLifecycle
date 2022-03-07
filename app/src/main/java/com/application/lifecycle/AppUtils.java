package com.application.lifecycle;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

public class AppUtils {
    /**
     * 是否处于调试运行状态
     * @return
     */
    public static boolean isDebugApp(){
        return isDebugApp(getApp());
    }
    /**
     * 是否处于调试运行状态
     * @param context
     * @return
     */
    public static boolean isDebugApp(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception x) {
            return false;
        }
    }

    private AppUtils() {}

    /**
     * 获取应用上下文
     * @return
     */
    public static Application getApp() {
        return MyApplication.instance;
    }

    public static String getSystemProperty(String name) throws Exception {
        Class systemPropertyClazz = Class.forName("android.os.SystemProperties");
        return (String) systemPropertyClazz.getMethod("get", new Class[]{String.class})
                .invoke(systemPropertyClazz, new Object[]{name});
    }
}