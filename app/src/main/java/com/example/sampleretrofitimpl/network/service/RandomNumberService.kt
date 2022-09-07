package com.example.sampleretrofitimpl.network.service

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomNumberService {

    @GET("/api/v1.0/random")
    suspend fun getRandomNumber(@Query("min") min:Int, @Query("max") max: Int, @Query("count") count:Int):List<Int>

    companion object {
        val BASE_URL = "http://www.randomnumberapi.com/"
        fun createService(): RandomNumberService {
            return RetrofitClientGenerator.getRetrofitClient(BASE_URL).create(RandomNumberService::class.java)
        }
    }

}