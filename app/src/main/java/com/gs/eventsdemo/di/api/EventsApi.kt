package com.gs.eventsdemo.di.api

import com.gs.eventsdemo.di.models.EventModel
import retrofit2.http.GET

interface EventsApi {
    @GET("/getEvents")
    suspend fun getEvents():List<EventModel>
}

