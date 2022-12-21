package com.example.innoventes.api

sealed class UiState<T> {
    class Loading<T> : UiState<T>()

    class Success<T>(res: T? = null) : UiState<T>()

    class Error<T>(msg: String?) : UiState<T>()
}
