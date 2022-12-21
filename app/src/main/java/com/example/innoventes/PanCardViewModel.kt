package com.example.innoventes

import androidx.lifecycle.ViewModel
import com.example.innoventes.api.NetworkInterface
import com.example.innoventes.model.PanCardRequestModel
import javax.inject.Inject

class PanCardViewModel @Inject constructor(private val networkInterface: NetworkInterface) :
    ViewModel() {


    fun validateRequest(request: PanCardRequestModel) {
    }


    fun submitPanCardDetails() {

    }
}