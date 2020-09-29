package com.example.kotlinrandd.data.network.responses

import com.example.kotlinrandd.data.room.entities.User

data class AuthResponse (
    val isSuccessful: Boolean?,
    val message:String?,
    val user: User?
)