package com.example.innoventes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.innoventes.base.BaseApplication
import com.example.innoventes.databinding.ActivityPanCardBinding
import javax.inject.Inject

class PanCardActivity : AppCompatActivity() {


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
        setUpListener()
    }

    private fun setUpListener() {
        mBinding.btnNext.setOnClickListener {

        }
        mBinding.labelDontHavePan.setOnClickListener {
            finish()
        }
    }
}