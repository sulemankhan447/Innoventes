package com.example.innoventes.base

import android.app.Application
import com.example.innoventes.di.AppComponent

class BaseApplication : Application() {


    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.Builder().build()
    }
}