package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @get:GET("en/opendata/category/109/json")
    var posts: Call<Response?>?

    companion object {
        const val BASE_URL = "http://www.stat.kg"
    }
}