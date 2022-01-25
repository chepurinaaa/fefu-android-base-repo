package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.ItemAdapter
import ru.fefu.activitytracker.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityFragmentMyActivitiesBinding

class ActivityMyFragment : BaseFragment<ActivityFragmentMyActivitiesBinding>(R.layout.activity_fragment_my_activities) {

    private val listRepository = MyListRepository()
    private val adapterItems = ItemAdapter(listRepository.getItem())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rcView) {
            adapter = adapterItems
            layoutManager = LinearLayoutManager(requireContext())
        }

        adapterItems.setItemClickListener {
            val manager = activity?.supportFragmentManager?.findFragmentByTag("activityFragment")?.childFragmentManager
            manager?.beginTransaction()?.apply {
                manager.fragments.forEach(::hide)
                replace(
                    R.id.activity_fragment_flow_container,
                    MyActivityDetailsFragment.newInstance(listRepository.getItem()[it] as ListItem.Item)
                )
                addToBackStack(null)
                commit()
            }
        }

    }
}