package ru.fefu.activitytracker.main

import ru.fefu.activitytracker.ListItem

class MyListRepository {
    private val listItem = listOf(
        ListItem.Date(
            date = "Вчера"
        ),

        ListItem.Item(
            distance = "100 км",
            time = "8 часов 46 минут",
            date = "5 минут назад",
            startTime = "14:15",
            endTime = "22:01",
            activity = "Велосипед \uD83D\uDEB2",
        ),

        ListItem.Date(
            date = "Апрель 2021 года"
        ),

        ListItem.Item(
            distance = "5 км",
            time = "65 минут",
            date = "01.04.2021",
            startTime = "12:03",
            endTime = "13:08",
            activity = "Серфинг  \uD83C\uDFC4",
        )
    )

    fun getItem() : List<ListItem> = listItem
}