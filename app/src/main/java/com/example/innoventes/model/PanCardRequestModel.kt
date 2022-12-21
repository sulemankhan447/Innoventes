package com.example.innoventes.model

data class PanCardRequestModel(
    var panCard: String? = "",
    var date: String? = "",
    var month: String? = "",
    var year: String? = ""
)


data class PanCardResponseModel(
    var success: Boolean = false
)
