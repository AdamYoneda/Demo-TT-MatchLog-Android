package com.example.myapplication_2.model

// 試合の詳細 (スコア、対戦相手、所属チーム)
data class Match(
    val score: String,
    val opponentName: String?,
    val opponentTeam: String?
)
