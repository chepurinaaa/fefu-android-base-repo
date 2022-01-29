package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.databinding.ActivityFragmentMyActivitiesBinding


class ActivityMyFragment : Fragment() {
    private lateinit var binding: ActivityFragmentMyActivitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityFragmentMyActivitiesBinding.inflate(inflater, container, false)
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

        fun newInstance(): ActivityMyFragment {
            val bundle = Bundle()
            val fragment = ActivityMyFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    private fun getActivityData(): List<ActivityData> {
        return listOf(
            ActivityData("5 км", "2 часа", "Велосипед", "", "20.04.2021"),
            ActivityData("6 км", "2 часа", "Велосипед", "", "25.02.2021"),
            ActivityData("4 км", "1 час", "Велосипед", "", "25.02.2021"),
        )
    }
}