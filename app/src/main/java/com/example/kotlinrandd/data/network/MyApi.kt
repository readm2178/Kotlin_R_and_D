package com.example.kotlinrandd.data.network

import com.example.kotlinrandd.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")

    suspend fun userLogin(

        @Field("email") email: String,
        @Field("password")password: String
//        @Field("name")name:String

    ):Response<AuthResponse>

    companion object{

        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }

    }
}