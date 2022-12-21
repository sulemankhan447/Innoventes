package com.example.innoventes.api

import com.example.innoventes.Constants
import com.example.innoventes.model.PanCardRequestModel
import com.example.innoventes.model.PanCardResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkInterface {


    @POST(Constants.SUBMIT_PAN)
    suspend fun submitPanCardDetails(@Body request: PanCardRequestModel): Response<PanCardResponseModel>
}