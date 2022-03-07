package com.application.lifecycle

import android.util.Log

object LogHelper {
    const val TAG = "log_tag"

    /**
     * 只在debug模式打印
     */
    @JvmStatic
    fun d(msg:String){
        if(AppUtils.isDebugApp()){
            Log.d(TAG,msg)
        }
    }

    /**
     * 所有模式都打印日志
     */
    @JvmStatic
    fun logAlways(msg:String){
        Log.d(TAG,msg)
    }
}