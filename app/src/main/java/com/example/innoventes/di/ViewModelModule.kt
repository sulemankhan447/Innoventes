package com.example.innoventes.di

import androidx.lifecycle.ViewModel
import com.example.innoventes.PanCardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @ClassKey(PanCardViewModel::class)
    @IntoMap
    abstract fun providesViewModelFactory(panCardViewModel: PanCardViewModel): ViewModel
}