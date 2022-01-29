package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.ActivityFragmentUsersActivitiesDetailsBinding


class ActivityUsersDetailsFragment : Fragment() {
    private lateinit var binding: ActivityFragmentUsersActivitiesDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityFragmentUsersActivitiesDetailsBinding.inflate(inflater, container, false)
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

        const val TAG = "activity_fragment_users_activities_details"

        fun newInstance(): ActivityUsersDetailsFragment {
            val bundle = Bundle()
            val fragment = ActivityUsersDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}