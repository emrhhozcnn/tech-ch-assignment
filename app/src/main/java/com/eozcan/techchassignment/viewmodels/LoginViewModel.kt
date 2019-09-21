package com.eozcan.techchassignment.viewmodels

import androidx.databinding.BaseObservable
import com.eozcan.techchassignment.constants.Settings
import com.eozcan.techchassignment.models.User

class LoginViewModel(val callbackOnSuccessLogin: LoginListener) : BaseObservable() {
    val user = User("", "")
    var rememberMe = false

    fun onLoginClicked() {
        if (user.name.equals(Settings.VALID_USER_NAME) && user.password.equals(Settings.VALID_PASSWORD)) {
            callbackOnSuccessLogin.onLogicSucceded(rememberMe)
        } else {
            // TODO show alert
        }
    }
}

// Activity başlatmak ve beni hatırla işlemi için
interface LoginListener {
    fun onLogicSucceded(rememberMeActive: Boolean)
}