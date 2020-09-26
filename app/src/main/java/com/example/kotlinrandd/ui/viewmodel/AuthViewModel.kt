package com.example.kotlinrandd.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.kotlinrandd.data.repositories.UserReposirory
import com.example.kotlinrandd.ui.auth.AuthListner

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListner: AuthListner? = null

    fun onLoginButtonClick(view: View) {

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListner?.onFailure("Invaild email and password")
            return
        }
        //getting response from the repository here we to pass and show to login activity using Interface

        val loginResponse= UserReposirory().userLogin(email!!,password!!)

        authListner?.onSuccess(loginResponse)

    }


}