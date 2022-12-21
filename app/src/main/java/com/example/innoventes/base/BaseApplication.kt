package com.example.innoventes.base

import android.app.Application
import com.example.innoventes.di.AppComponent
import com.example.innoventes.di.DaggerAppComponent

class BaseApplication : Application() {


    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}