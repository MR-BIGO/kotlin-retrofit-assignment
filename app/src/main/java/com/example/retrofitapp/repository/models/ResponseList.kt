package com.example.retrofitapp.repository.models

import com.google.gson.annotations.SerializedName

data class ResponseList(
    val page: Int,

    @SerializedName("per_page")
    val perPage: Int,

    val total: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    val data: List<User>,

    val support: Support
)
