package ru.fefu.activitytracker.main

import ru.fefu.activitytracker.ListItem

class UsersListRepository {
    private val usersListItem = listOf(
        ListItem.Date(
            date = "Вчера",
        ),
        ListItem.Item(
            distance = "15 км",
            time = "3 часа 45 минут",
            activity = "Серфинг \uD83C\uDFC4",
            date = "5 часов назад",
            startTime = "13:00",
            endTime = "15:45",
            user = "@user1",
        ),
        ListItem.Item(
            distance = "200 м",
            time = "10 часов",
            activity = "Велосипед \uD83D\uDEB2",
            date = "5 часов назад",
            startTime = "00:00",
            endTime = "10:00",
            user = "@user2",
        ),
        ListItem.Item(
            distance = "500 км",
            time = "5 часов 5 минут",
            activity = "Велосипед \uD83D\uDEB2",
            date = "10 часов назад",
            startTime = "20:35",
            endTime = "01:40",
            user = "@user3",
        ),
    )

    fun getItem() : List<ListItem> = usersListItem
}