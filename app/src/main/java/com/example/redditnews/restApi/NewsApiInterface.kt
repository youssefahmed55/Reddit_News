package com.example.redditnews.restApi

import com.example.redditnews.pojo.NewsResponse
import retrofit2.http.GET

interface NewsApiInterface {
    //Get NewsResponse
    @GET("r/kotlin/.json")
    suspend fun getNewsRequest() : NewsResponse
}