package com.example.sampleretrofitimpl.network.service.repository

import com.example.sampleretrofitimpl.network.service.RandomNumberService
import com.example.sampleretrofitimpl.network.service.data.RandomResponse
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.coroutines.CoroutineContext


class RandomNumberRepoImpl(val service: RandomNumberService):RandomNumberRepo, CoroutineScope {


    private val countinesExceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + countinesExceptionHandler

    override suspend fun getRandomNumber(min: Int, max: Int, count: Int): Result<List<Int>> = withContext(Dispatchers.IO){
        runCatching { service.getRandomNumber(min,max, count) }
    }


}
