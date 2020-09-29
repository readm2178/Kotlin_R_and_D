package com.example.kotlinrandd.data.repositories


import com.example.kotlinrandd.data.network.MyApi
import com.example.kotlinrandd.data.network.responses.AuthResponse
import retrofit2.Response

class UserReposirory {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {

//passing data to api and return the res
        return MyApi().userLogin(email, password)

    }
}