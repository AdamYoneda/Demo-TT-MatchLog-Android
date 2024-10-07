package com.example.myapplication_2.data.model

import com.google.firebase.Timestamp

data class User(
    val userId: String = "",
    val userName: String = "",
    val email: String = "",
    val joinedDate: Timestamp? = null
)