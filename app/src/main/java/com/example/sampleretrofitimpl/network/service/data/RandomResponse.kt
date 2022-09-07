package com.example.sampleretrofitimpl.network.service.data

import java.lang.Exception

data class RandomResponse<out T>(val response:T?, val error: Exception?)
