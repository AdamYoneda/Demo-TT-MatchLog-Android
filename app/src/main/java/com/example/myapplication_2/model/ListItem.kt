package com.example.myapplication_2.model

sealed class ListItem {
    data class TournamentItem(val tournament: Tournament) : ListItem()
    data class MatchItem(val match: Match) : ListItem()
}
