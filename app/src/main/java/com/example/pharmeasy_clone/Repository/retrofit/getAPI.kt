package com.example.pharmeasy_clone.view

import retrofit2.Call
import retrofit2.http.GET

interface getAPI {
    @GET("raw/25f605e2961e8718f068eed19e3f90799aa40909/gistfile1.txt")
    fun getData(): Call<Response>
}