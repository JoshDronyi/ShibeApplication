package com.example.shibeapplication.repositories;

import com.example.shibeapplication.retrofit.RetrofitInstance;
import com.example.shibeapplication.retrofit.ShibeInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class Repository implements ShibeInterface {

    private Repository() {

    }

    private static class RepositoryHolder {
        public static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return RepositoryHolder.INSTANCE;
    }


    @Override
    public Call<List<String>> getShibes(int count) {

        return RetrofitInstance.getInstance()
                .create(ShibeInterface.class)
                .getShibes(count);

    }
}
