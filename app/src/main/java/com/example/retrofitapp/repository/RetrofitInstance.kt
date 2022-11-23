package com.example.retrofitapp.repository

import com.example.retrofitapp.repository.`interface`.IResponseList

import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    val retrofit: IResponseList by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IResponseList::class.java)
    }

}