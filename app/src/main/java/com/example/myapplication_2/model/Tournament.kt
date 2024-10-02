package com.example.myapplication_2.model

// 大会セクション (日付、試合形式、大会名、試合リスト)
data class Tournament(
    val date: String,                     // 大会日付
    val tournamentName: String,           // 大会名
    val matchType: MatchType,             // 試合形式（シングルス、ダブルス、団体戦）
    val matches: List<Match>              // 試合リスト
)
