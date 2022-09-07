package com.example.sampleretrofitimpl.network.service.repository

import com.example.sampleretrofitimpl.network.service.data.RandomResponse
import retrofit2.Response

interface RandomNumberRepo {

    suspend fun getRandomNumber(min:Int, max:Int, count: Int): List<Int>?

}