package com.example.innoventes.base

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.innoventes.di.AppComponent
import com.example.innoventes.di.DaggerAppComponent

class BaseApplication : Application() {


    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}