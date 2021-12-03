package com.example.shibeapplication.model.repositories

import com.example.shibeapplication.model.retrofit.ShibeInterface
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class Repository @Inject constructor(private val retrofit: Retrofit) : ShibeInterface {

    override fun getShibes(count: Int): Call<List<String>> {
        return retrofit
                .create(ShibeInterface::class.java)
                .getShibes(count)
    }

}