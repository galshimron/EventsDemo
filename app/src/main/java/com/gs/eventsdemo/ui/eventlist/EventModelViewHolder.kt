package com.gs.eventsdemo.ui.eventlist

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gs.eventsdemo.databinding.EventItemViewHolderBinding
import com.gs.eventsdemo.di.models.EventModel
import com.gs.eventsdemo.utils.formatDate
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
            tvDate.text = eventModel.date.formatDate()
        }

        itemView.setOnClickListener {
            clickListener.invoke(eventModel)
        }
    }
}
