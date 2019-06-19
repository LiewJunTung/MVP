package org.liewjuntung.mvp

import android.app.Application
import android.content.Context

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }
}