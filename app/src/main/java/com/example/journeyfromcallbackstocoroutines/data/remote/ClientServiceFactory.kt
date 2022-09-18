package com.example.journeyfromcallbackstocoroutines.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientServiceFactory(var baseUrl : String) {

    val service : APIsInterface = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIsInterface::class.java)
}