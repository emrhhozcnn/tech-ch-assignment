package com.eozcan.techchassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.databinding.ActivityLoginBinding
import com.eozcan.techchassignment.viewmodels.LoginListener
import com.eozcan.techchassignment.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        // viewModel'den activity başlatmak için interface tanımlayıp kullandım.
        binding.viewModel = LoginViewModel(object : LoginListener {
            override fun onLogicSucceded(rememberMeActive: Boolean) {
                // TODO save rememberMe param for future login.
                // TODO start ordersActivity
            }
        })

    }
}
