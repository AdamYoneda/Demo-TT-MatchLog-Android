package com.example.myapplication_2.presentation.view.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_2.R

class MatchInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_input)

        // Viewの取得
        val matchListView: ListView = findViewById(R.id.matchListView)
        val addItemButton: Button = findViewById(R.id.addItemButton)
        val confirmButton: Button = findViewById(R.id.confirmButton)
    }
}