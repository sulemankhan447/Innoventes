package com.example.innoventes.model

data class PanCardRequestModel(
    var panCard: String? = "",
    var date: Int? = 0,
    var month: Int? = 0,
    var year: Int? = 0
)


data class PanCardResponseModel(
    var success: Boolean = false
)
