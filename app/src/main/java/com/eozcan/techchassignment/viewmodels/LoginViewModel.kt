package com.eozcan.techchassignment.viewmodels

import androidx.databinding.BaseObservable
import com.eozcan.techchassignment.models.User

class LoginViewModel : BaseObservable() {
    val user = User("", "")
    var rememberMe = false

    fun onLoginClicked() {
        // TODO
    }
}