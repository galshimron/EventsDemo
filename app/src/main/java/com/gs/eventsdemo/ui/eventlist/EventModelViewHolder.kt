package com.gs.eventsdemo.ui.eventlist

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gs.eventsdemo.databinding.EventItemViewHolderBinding
import com.gs.eventsdemo.ui.di.models.EventModel
import java.lang.Exception

class EventModelViewHolder(val eventItemViewHolderBinding: EventItemViewHolderBinding):RecyclerView.ViewHolder(eventItemViewHolderBinding.root) {
    val TAG = "EventModelViewHolder"

    fun bind(eventModel: EventModel, clickListener: (clickItem: EventModel) -> Unit){

        eventItemViewHolderBinding?.apply{
            this.eventModel = eventModel
            if (!eventModel.imageUrl.isNullOrEmpty()){
                try{
                    Glide.with(itemView.context).load(eventModel.imageUrl).into(ivEventImage)
                }catch (e:Exception){
                    Log.e(TAG, "bind: Exception Glide failed ${e.message}, ${e.stackTraceToString()}", )
                }
            }
        }

        itemView.setOnClickListener {
            clickListener.invoke(eventModel)
        }
    }
}
