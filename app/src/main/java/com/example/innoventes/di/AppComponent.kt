package com.example.innoventes.di

import androidx.lifecycle.ViewModel
import com.example.innoventes.PanCardActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(panCardActivity: PanCardActivity)

    fun getMap(): Map<Class<*>, ViewModel>
}