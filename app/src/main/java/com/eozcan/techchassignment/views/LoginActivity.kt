package com.eozcan.techchassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.databinding.ActivityLoginBinding
import com.eozcan.techchassignment.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        // viewModel'den activity başlatılamayacağı için runnable ile action'ı yakalandım.
        binding.viewModel = LoginViewModel(Runnable {
            // TODO start ordersActivity
        })

    }
}
