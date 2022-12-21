package com.example.innoventes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.innoventes.api.NetworkInterface
import javax.inject.Inject

class PanCardViewModelFactory @Inject constructor(private val networkInterface: NetworkInterface) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PanCardViewModel(networkInterface) as T
    }
}