package com.example.myapplication_2.model

// 大会セクション (日付と大会名)
data class Tournament (
    val date: String,
    val tournamentName: String,
    val matches: List<Match>
)