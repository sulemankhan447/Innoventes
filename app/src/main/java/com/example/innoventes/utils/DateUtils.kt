package com.example.innoventes.utils

import java.text.ParseException
import java.text.SimpleDateFormat

object DateUtils {

    fun isValidDate(dateStr: String): Boolean {
        val sdf = SimpleDateFormat("dd/MM/")
        sdf.isLenient = false
        try {
            sdf.parse(dateStr)
        } catch (e: ParseException) {
            return false
        }
        return true
    }
}