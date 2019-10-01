package com.example.shibeapplication.retrofit;

import com.example.shibeapplication.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    //This should be a singleton
    private RetrofitInstance() {

    }

    static class RetrofitInstanceHolder {
        static final Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        return RetrofitInstanceHolder.INSTANCE;
    }

}
