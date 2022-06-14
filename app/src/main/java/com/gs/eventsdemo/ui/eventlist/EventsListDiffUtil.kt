package com.gs.eventsdemo.ui.eventlist

import androidx.recyclerview.widget.DiffUtil
import com.gs.eventsdemo.ui.di.models.EventModel

class EventsListDiffUtil: DiffUtil.ItemCallback<EventModel>() {
    override fun areItemsTheSame(oldItem: EventModel, newItem: EventModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EventModel, newItem: EventModel): Boolean {
        return oldItem == newItem
    }
}