package com.example.lab2.view.login

import android.util.Log
import com.example.bookhotels.websecvice.Client
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel(val loginListener: LoginListener) {
    fun postData(username:String,password:String){
        val cal:Call<ResponseBody> = Client.getService()!!.postLogin(username,password)
        cal.enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginListener.logginFalse()
                Log.d("TAGDDĐ",""+"False")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                Log.d("TAGDDĐ",""+response.body()!!.string())
                if (response.isSuccessful || response.body()!=null){
                    loginListener.logginSuccess(response.body()!!.string())
                }

            }

        })
    }
}