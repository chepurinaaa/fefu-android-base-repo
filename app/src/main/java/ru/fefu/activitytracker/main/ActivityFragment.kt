package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityFragmentActivityBinding

class ActivityFragment : Fragment(R.layout.activity_fragment_activity) {
    private lateinit var binding: ActivityFragmentActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityFragmentActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        const val TAG = "activity_fragment_activity"

        fun newInstance(): ActivityFragment {
            val bundle = Bundle()
            val fragment = ActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                add(R.id.fcvActivity, ActivityAllFragment.newInstance(), ActivityAllFragment.TAG)
                commit()
            }
        }
    }


}