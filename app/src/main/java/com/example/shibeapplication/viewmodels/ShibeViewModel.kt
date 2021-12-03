package com.example.shibeapplication.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shibeapplication.model.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class ShibeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getShibes(count: Int): Call<List<String>> {
        return repository.getShibes(count)
    }
}