package com.example.myapplication_2.model

// 試合形式の列挙型にStringの値を持たせる
enum class MatchType(val type: String) {
    SINGLES("Singles"),
    DOUBLES("Doubles"),
    TEAM("Team");

    // String型の値を取得する関数
    fun getValue(): String {
        return type
    }
}