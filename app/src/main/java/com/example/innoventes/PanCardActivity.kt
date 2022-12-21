package com.example.innoventes

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.innoventes.`interface`.ValidationListener
import com.example.innoventes.api.UiState
import com.example.innoventes.base.BaseApplication
import com.example.innoventes.databinding.ActivityPanCardBinding
import com.example.innoventes.model.PanCardRequestModel
import com.example.innoventes.model.PanCardResponseModel
import javax.inject.Inject

class PanCardActivity : AppCompatActivity(), ValidationListener {


    lateinit var mBinding: ActivityPanCardBinding


    lateinit var panCardViewModel: PanCardViewModel

    @Inject
    lateinit var panCardViewModelFactory: PanCardViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_pan_card)
        (application as BaseApplication).appComponent.inject(this)
        panCardViewModel =
            ViewModelProvider(this, panCardViewModelFactory)[PanCardViewModel::class.java]
        panCardViewModel.validationListener = this
        setUpListener()
        setUpObserver()
    }

    private fun setUpObserver() {
        panCardViewModel.uiState.observe(this) {
            when (it) {
                is UiState.Loading -> {
                    showLoader()
                }
                is UiState.Success -> {
                    hideLoader()
                    Toast.makeText(
                        this,
                        "Your details are successfully submitted",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is UiState.Error -> hideLoader()
            }
        }
    }

    private fun hideLoader() {

    }

    private fun showLoader() {

    }

    private fun setUpListener() {
        mBinding.btnNext.setOnClickListener {


            panCardViewModel.validateRequest(getPanCardRequestModel())
        }
        mBinding.labelDontHavePan.setOnClickListener {
            finish()
        }
    }

    private fun getPanCardRequestModel(): PanCardRequestModel {
        val date = if (!TextUtils.isEmpty(mBinding.edtDate.text.toString())) {
            mBinding.edtDate.text.toString().toInt()
        } else {
            -1
        }

        val month = if (!TextUtils.isEmpty(mBinding.edtMonth.text.toString())) {
            mBinding.edtMonth.text.toString().toInt()
        } else {
            -1
        }
        val year = if (!TextUtils.isEmpty(mBinding.edtYear.text.toString())) {
            mBinding.edtYear.text.toString().toInt()
        } else {
            -1
        }
        val request = PanCardRequestModel(
            panCard = mBinding.edtPancard.text.toString(),
            date = date,
            month = month,
            year = year
        )
        return request
    }

    override fun onSuccess() {
        panCardViewModel.submitPanCardDetails(getPanCardRequestModel())
    }

    override fun onFailure(msg: Int) {
        Toast.makeText(this, getString(msg), Toast.LENGTH_LONG).show()
    }
}