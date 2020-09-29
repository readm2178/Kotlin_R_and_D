package com.example.kotlinrandd.ui.auth

import com.example.kotlinrandd.data.room.entities.User

interface AuthListner {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message : String)
}