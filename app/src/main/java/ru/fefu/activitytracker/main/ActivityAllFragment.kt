package ru.fefu.activitytracker.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityFragmentActivityAllBinding

class ActivityAllFragment : Fragment(R.layout.activity_fragment_activity_all) {
    private lateinit var binding: ActivityFragmentActivityAllBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityFragmentActivityAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        const val TAG = "activity_fragment_activity_all"

        fun newInstance(): ActivityAllFragment {
            val bundle = Bundle()
            val fragment = ActivityAllFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vpActivity.adapter = ActivityAllFragmentAdapter(this)
        TabLayoutMediator(
            binding.tlActivityGroup,
            binding.vpActivity
        ) { tab, position ->
            if (position == 0) {
                tab.text = "Моя"
            } else {
                tab.text = "Пользователи"
            }
        }.attach()
    }
}

class ActivityAllFragmentAdapter(fragment: ActivityAllFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            ActivityMyFragment.newInstance()
        } else {
            ActivityUsersFragment.newInstance()
        }
}