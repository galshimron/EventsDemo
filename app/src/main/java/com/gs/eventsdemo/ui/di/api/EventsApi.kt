package com.gs.eventsdemo.ui.di.api

import com.gs.eventsdemo.ui.di.models.EventModel
import retrofit2.http.GET

interface EventsApi {
    @GET("/getEvents")
    suspend fun getEvents():List<EventModel>
}

