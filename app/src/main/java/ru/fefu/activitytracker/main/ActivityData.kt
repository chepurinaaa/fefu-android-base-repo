package ru.fefu.activitytracker.main

data class ActivityData (
    val distance: String,
    val duration: String,
    val type: String,
    val username: String,
    val date: String
) : ActivityDataModel