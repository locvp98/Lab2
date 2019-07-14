package com.example.lab2.view.home

import com.example.bookhotels.websecvice.Client
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeModel(val homeListener: HomeListener) {

    fun getData(today:String){
        val cal:Call<ResponseBody> = Client.getService()!!.getData(today)
        cal.enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    homeListener.data(response.body()!!.string())
                }
            }

        })
    }
}