package com.example.shibeapplication.model.retrofit

import com.example.shibeapplication.Utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShibeInterface {
    @GET(Constants.SHIBE_PATH)
    fun getShibes(@Query("count") count: Int): Call<List<String>>
}