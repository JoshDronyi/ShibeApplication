package com.example.shibeapplication.model.retrofit

import android.content.Context
import android.view.LayoutInflater
import com.example.shibeapplication.Utils.Constants
import com.example.shibeapplication.databinding.ActivityMainBinding
import com.example.shibeapplication.model.repositories.Repository
import com.example.shibeapplication.viewmodels.ShibeViewModel
import com.example.shibeapplication.views.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ShibeModule {

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesRepository() = Repository(providesRetrofit())

    @Provides
    fun providesShibeViewModel() = ShibeViewModel(providesRepository())


    @Provides
    fun provideBinding(@ApplicationContext context: Context) =
            ActivityMainBinding.inflate(LayoutInflater.from(context))

    @Provides
    fun providesApplicationContext() = MainActivity::getApplicationContext

}