package com.gs.eventsdemo.ui.eventlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.gs.eventsdemo.R
import com.gs.eventsdemo.databinding.EventItemViewHolderBinding
import com.gs.eventsdemo.di.models.EventModel

class EventsListFragmentAdapter(private val  clickListener: (clickItem: EventModel) -> Unit) : ListAdapter<EventModel,EventModelViewHolder>(EventsListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventModelViewHolder {
        val eventItemViewHolderBinding = DataBindingUtil.inflate<EventItemViewHolderBinding>(
            LayoutInflater.from(parent.context),
            R.layout.event_item_view_holder,
            parent,
            false
        )
        return EventModelViewHolder(eventItemViewHolderBinding)
    }

    override fun onBindViewHolder(holder: EventModelViewHolder, position: Int) {
        holder.bind(currentList[position], clickListener)
    }
}
