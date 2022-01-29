package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.ActivityFragmentMyActivitiesDetailsBinding


class ActivityMyDetailsFragment : Fragment() {
    private lateinit var binding: ActivityFragmentMyActivitiesDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityFragmentMyActivitiesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = binding.tbActivityDetail
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {

        const val TAG = "activity_fragment_my_activities_details"

        fun newInstance(): ActivityMyDetailsFragment {
            val bundle = Bundle()
            val fragment = ActivityMyDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}