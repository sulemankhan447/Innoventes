package com.example.innoventes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.innoventes.base.BaseApplication
import javax.inject.Inject

class PanCardActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var panCardViewModel: PanCardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pan_card)
        (application as BaseApplication).appComponent.inject(this)
    }
}