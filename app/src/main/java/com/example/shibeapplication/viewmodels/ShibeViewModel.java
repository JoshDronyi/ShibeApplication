package com.example.shibeapplication.viewmodels;

import com.example.shibeapplication.repositories.Repository;

import java.util.List;

import retrofit2.Call;

public class ShibeViewModel {

    public ShibeViewModel() {

    }

    public Call<List<String>> getShibes(int count) {
        return Repository.getInstance().getShibes(count);
    }

}
