package com.gs.eventsdemo.ui.di.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl ="https://us-central1-dazn-sandbox.cloudfunctions.net"

    fun getInstance(): EventsApi {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(EventsApi::class.java)

    }
}