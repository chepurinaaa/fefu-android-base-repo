package ru.fefu.activitytracker.main

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.R


class ActivityListAdapter(
    activityData: List<ActivityData>,
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var activityDataList = mutableListOf<ActivityDataModel>()

    init {
        val processedData = mutableMapOf<String, MutableList<ActivityData>>()
        activityData.forEach {
            if (processedData[it.date] == null) {
                processedData[it.date] = mutableListOf(it)
            } else {
                processedData[it.date]?.add(it)
            }

        }

        processedData.forEach { (date, data) ->
            activityDataList.add(SummaryActivityDate(date))
            data.forEach {
                activityDataList.add(it)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                ActivityDataViewHolder.create(parent)
            }
            1 -> {
                SummaryActivityDateViewHolder.create(parent)
            }
            else -> {
                throw Exception("Error reading holder type")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (activityDataList[position]::class == ActivityData::class) {
            0
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentData = activityDataList[position]
        when (holder.itemViewType) {
            0 -> {
                (holder as ActivityDataViewHolder).bind(
                    currentData as ActivityData
                )

                val detailFragmentTag: String
                val detailFragmentInstance: Fragment
                if (currentData.username.isEmpty()) {
                    detailFragmentTag = ActivityMyDetailsFragment.TAG
                    detailFragmentInstance = ActivityMyDetailsFragment.newInstance()
                } else {
                    detailFragmentTag = ActivityUsersDetailsFragment.TAG
                    detailFragmentInstance = ActivityUsersDetailsFragment.newInstance()
                }


                holder.itemView.setOnClickListener {
                    val currentFragment = fragmentManager.findFragmentByTag(ActivityAllFragment.TAG)
                    fragmentManager.beginTransaction().apply {
                        if (currentFragment != null) {
                            hide(currentFragment)
                        }
                        add(
                            R.id.fcvActivity,
                            detailFragmentInstance,
                            detailFragmentTag
                        )
                        addToBackStack(detailFragmentTag)
                        commit()
                    }
                }
            }
            1 -> (holder as SummaryActivityDateViewHolder).bind(
                currentData as SummaryActivityDate
            )
        }


    }

    override fun getItemCount(): Int {
        return activityDataList.size
    }

}