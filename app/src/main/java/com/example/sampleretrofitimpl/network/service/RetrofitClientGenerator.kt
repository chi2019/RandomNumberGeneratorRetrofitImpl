package com.example.sampleretrofitimpl.network.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientGenerator {

   fun getClient():OkHttpClient{
      return OkHttpClient.Builder()
         .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
         }).build()
   }

   fun getRetrofitClient(baseUrl:String): Retrofit {
      return Retrofit.Builder()
             .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
             .baseUrl(baseUrl)
             .build()
   }


}