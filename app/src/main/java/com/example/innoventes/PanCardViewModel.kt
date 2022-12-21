package com.example.innoventes

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innoventes.api.NetworkInterface
import com.example.innoventes.api.UiState
import com.example.innoventes.model.PanCardRequestModel
import com.example.innoventes.model.PanCardResponseModel
import com.example.innoventes.utils.DateUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.inject.Inject


class PanCardViewModel @Inject constructor(private val networkInterface: NetworkInterface) :
    ViewModel() {


    var validationListener: ValidationListener? = null

    var uiState = MutableLiveData<UiState<PanCardResponseModel>>()


    fun validateRequest(request: PanCardRequestModel) {

        val date = request.date ?: 0
        val month = request.month ?: 0
        val year = request.year ?: 0


        if (TextUtils.isEmpty(request.panCard)) {
            validationListener?.onFailure(R.string.pan_error)
            return
        }

        val pattern: Pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")

        val matcher: Matcher = pattern.matcher(request.panCard)


        // Check if pattern matches
        if (matcher.matches().not()) {
            validationListener?.onFailure(R.string.pan_error)
            return
        }

        if (date < 0) {
            validationListener?.onFailure(R.string.date_error)
            return
        }

        if (month < 0 || month > 12) {
            validationListener?.onFailure(R.string.month_error)
            return
        }
        if (year < 0) {
            validationListener?.onFailure(R.string.year_error)
            return
        }
        val dateStr = "$date/$month/$year"
        if(DateUtils.isValidDate(dateStr)){
            validationListener?.onFailure(R.string.valid_date_error)
            return
        }

        validationListener?.onSuccess()

    }


    fun submitPanCardDetails(request: PanCardRequestModel) {
        uiState.value = UiState.Loading()
        viewModelScope.launch {
            try {
                delay(1000)
                val response = networkInterface.submitPanCardDetails(request)
                uiState.value = UiState.Success(response.body())

            } catch (e: Exception) {
                uiState.value = UiState.Error("Failed to submit pan card details")
            }
        }


    }
}