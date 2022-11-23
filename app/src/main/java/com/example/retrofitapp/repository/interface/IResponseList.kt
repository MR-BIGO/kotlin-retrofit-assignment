package com.example.retrofitapp.repository.`interface`

import com.example.retrofitapp.repository.models.ResponseList
import com.example.retrofitapp.repository.models.ResponseUser


import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Path


interface IResponseList  {


    @GET("/api/users?page=2")
    suspend fun getData() : Response<ResponseList>

    @GET("/api/users/{id}")
    suspend fun getUser(@Path("id") id : Int) : Response<ResponseUser>


}