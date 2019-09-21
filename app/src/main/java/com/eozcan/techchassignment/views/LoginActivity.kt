package com.eozcan.techchassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.utils.AlertUtil
import com.eozcan.techchassignment.utils.SharedPreferencesUtil
import com.eozcan.techchassignment.constants.Params
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
                SharedPreferencesUtil.setBoolean(this@LoginActivity, Params.KEY_REMEMBER_ME, rememberMeActive)
                // TODO start ordersActivity
            }

            override fun onLoginFailed() {
                AlertUtil.showAlert(this@LoginActivity, R.string.app_name, R.string.login_fail_warning, R.string.ok)
            }
        })

    }
}
