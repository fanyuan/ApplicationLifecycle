package com.application.lifecycle

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {
    companion object{
        lateinit var instance:MyApplication
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        LogHelper.d("MyApplication --- onCreate")

        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())

        ProcessLifecycleOwner.get().lifecycle.addObserver(object :LifecycleEventObserver{
            /**
             * Called when a state transition event happens.
             *
             * @param source The source of the event
             * @param event The event
             */
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when(event){
                    Lifecycle.Event.ON_CREATE ->{
                        LogHelper.logAlways("MyApplication  ON_CREATE")
                    }
                    Lifecycle.Event.ON_START ->{LogHelper.logAlways("MyApplication  ON_START")}
                    Lifecycle.Event.ON_RESUME->{LogHelper.logAlways("MyApplication  ON_RESUME")}
                    Lifecycle.Event.ON_PAUSE ->{LogHelper.logAlways("MyApplication  ON_PAUSE")}
                    Lifecycle.Event.ON_STOP ->{LogHelper.logAlways("MyApplication  ON_STOP")}
                    Lifecycle.Event.ON_DESTROY ->{LogHelper.logAlways("MyApplication  ON_DESTROY")}
                }

            }
        })
    }
}