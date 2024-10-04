package com.example.myapplication_2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R

class MatchRecordActivity : AppCompatActivity() {
    // recyclerViewの変数を用意
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_record)

        // List
        val tournaments = listOf()

        // recyclerViewを表示させる
        recyclerView = findViewById(R.id.recyclerView) // idの取得
        recyclerView.adapter = MatchRecordAdapter(tournaments) // アダプターをセット
        recyclerView.layoutManager = LinearLayoutManager(this) // 各アイテムを縦に並べるように指示
    }
}