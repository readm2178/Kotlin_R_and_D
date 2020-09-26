package com.example.kotlinrandd.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinrandd.data.`package`.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserReposirory {

    fun userLogin(email: String, password: String): LiveData<String> {

        val loginResponse = MutableLiveData<String>()
//passing data to api
        MyApi().userLogin(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    //after getting response from the api need to pass to tht loginresp variable ...getting res by Throwable

                    loginResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        loginResponse.value = response.body()?.string()
                    } else {
                        loginResponse.value = response.body()?.string()
                    }
                }
            }
            )

        return loginResponse

    }
}