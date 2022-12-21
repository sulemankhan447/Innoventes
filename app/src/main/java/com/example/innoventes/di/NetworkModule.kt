package com.example.innoventes.di

import com.example.innoventes.Constants
import com.example.innoventes.api.NetworkInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun providesNetworkInterface(retrofit: Retrofit): NetworkInterface {
        return retrofit.create(NetworkInterface::class.java)
    }

}