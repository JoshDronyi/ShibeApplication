package com.example.shibeapplication.retrofit;

import com.example.shibeapplication.Utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShibeInterface {

    @GET(Constants.SHIBE_PATH)
    Call<List<String>> getShibes(@Query("count") int count);
}
