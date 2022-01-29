package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.databinding.ActivityFragmentUsersActivitiesBinding


class ActivityUsersFragment : Fragment() {
    private lateinit var binding: ActivityFragmentUsersActivitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityFragmentUsersActivitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = parentFragment?.let {
            ActivityListAdapter(
                getActivityData(),
                it.parentFragmentManager
            )
        }
        binding.rvActivities.adapter = adapter
        binding.rvActivities.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {

        fun newInstance(): ActivityUsersFragment {
            val bundle = Bundle()
            val fragment = ActivityUsersFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    private fun getActivityData(): List<ActivityData> {
        return listOf(
            ActivityData("5 км", "2 часа", "Велосипед", "@username1", "20.04.2021"),
            ActivityData("6 км", "3 часа", "Велосипед", "@username2", "25.02.2021"),
        )
    }
}