package com.example.innoventes

interface ValidationListener {
    fun onSuccess() {}
    fun onFailure(msg: Int) {}
}