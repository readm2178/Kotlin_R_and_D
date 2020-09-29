package com.example.kotlinrandd.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinrandd.R
import com.example.kotlinrandd.data.room.entities.User
import com.example.kotlinrandd.databinding.ActivityLoginBinding
import com.example.kotlinrandd.ui.viewmodel.AuthViewModel
import com.example.kotlinrandd.util.hide
import com.example.kotlinrandd.util.show
import com.example.kotlinrandd.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //need to bind the view model
        //ActivityLoginBinding--> Automatically gen class

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListner = this
    }

    override fun onStarted() {
        toast("Login Started")
        progress_bar.show()

    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }

}

