package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityFragmentMyActivitiesDetailsBinding

class MyActivityDetailsFragment(details: ListItem.Item) :
    BaseFragment<ActivityFragmentMyActivitiesDetailsBinding>(R.layout.activity_fragment_my_activities_details) {
    private var _binding: ActivityFragmentMyActivitiesDetailsBinding? = null
    override val binding get() = _binding!!
    private val detail = details

    companion object {
        fun newInstance(info: ListItem.Item): MyActivityDetailsFragment {
            return MyActivityDetailsFragment(info)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textMyDistance.text = detail.distance
        binding.textMyDate.text = detail.date
        binding.textMyTime.text = detail.time
        binding.textMyStartTime.text = detail.startTime
        binding.textMyFinishTime.text = detail.endTime
        binding.toolbarMy.title = detail.activity
        binding.toolbarMy.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        binding.toolbarMy.setOnMenuItemClickListener {
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityFragmentMyActivitiesDetailsBinding.inflate(inflater, container, false)
        return binding.root    }

}