package com.example.bookhotels.websecvice

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @FormUrlEncoded
    @POST("/android/login.php")
    fun postLogin(
        @Field("username") username: String,
        @Field("password") password: String


    ): Call<ResponseBody>

    @GET("/android/bai1.php")
    fun getData(@Query("food") today: String): Call<ResponseBody>

}