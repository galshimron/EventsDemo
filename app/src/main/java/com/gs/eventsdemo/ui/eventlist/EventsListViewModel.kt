package com.gs.eventsdemo.ui.eventlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gs.eventsdemo.ui.di.api.RetrofitHelper
import com.gs.eventsdemo.ui.di.models.EventModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class EventsListViewModel : ViewModel() {
    private val TAG = "EventsListViewModel"

    private val _eventsData = MutableLiveData<List<EventModel>>()
    val eventsData : LiveData<List<EventModel>> =  _eventsData

    fun getEventsData(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val events = RetrofitHelper.getInstance().getEvents()
                _eventsData.postValue(events)
            }catch (e:Exception){
                Log.e(TAG, "getEventsData: Exception ${e.message}, ${e.stackTraceToString()}", )
            }
        }
    }

}
