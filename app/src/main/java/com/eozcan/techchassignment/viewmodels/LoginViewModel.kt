package com.eozcan.techchassignment.viewmodels

import androidx.databinding.BaseObservable
import com.eozcan.techchassignment.constants.Settings
import com.eozcan.techchassignment.models.User

class LoginViewModel(val loginListener: LoginListener) : BaseObservable() {
    val user = User("", "")
    var rememberMe = false

    fun onLoginClicked() {
        if (user.name.equals(Settings.VALID_USER_NAME) && user.password.equals(Settings.VALID_PASSWORD)) {
            loginListener.onLogicSucceded(rememberMe)
        } else {
            loginListener.onLoginFailed()
        }
    }
}

// Activity başlatmak ve beni hatırla işlemi için
interface LoginListener {
    fun onLogicSucceded(rememberMeActive: Boolean)
    fun onLoginFailed()
}