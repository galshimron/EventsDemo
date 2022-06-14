package com.gs.eventsdemo.ui.eventlist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gs.eventsdemo.R
import com.gs.eventsdemo.databinding.EventsListFragmentLayoutBinding
import com.gs.eventsdemo.ui.di.models.EventModel
import java.lang.Exception

class EventsListFragment:Fragment() {

    private val TAG ="EventsListFragment"

    private lateinit var eventsListFragmentLayoutBinding: EventsListFragmentLayoutBinding

    private lateinit var eventsListFragmentAdapter: EventsListFragmentAdapter

    private val eventsListViewModel: EventsListViewModel by viewModels<EventsListViewModel>()

    private val listItemClickListener : (clickItem:EventModel) -> Unit = {
        try {
            val intent = Intent(Intent.ACTION_VIEW, it.videoUrl.toUri())
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intent)
        }catch (e:Exception){
            Log.e(TAG, "listItemClickListener : Exception ${e.message}, ${e.stackTraceToString()}", )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventsListFragmentAdapter = EventsListFragmentAdapter(listItemClickListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        eventsListFragmentLayoutBinding = DataBindingUtil.inflate<EventsListFragmentLayoutBinding>(layoutInflater, R.layout.events_list_fragment_layout, container, false)
        return eventsListFragmentLayoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventsListFragmentLayoutBinding?.apply {
            rcvEventsList?.apply {
                addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                adapter = eventsListFragmentAdapter
            }
        }

        eventsListViewModel.eventsData.observe(viewLifecycleOwner){
            eventsListFragmentAdapter.submitList(it)

        }
        eventsListViewModel.getEventsData()
    }
}