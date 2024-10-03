package com.example.myapplication_2.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<MatchViewHolderItem>() {
    // A. 1行分のレイアウト(View)を生成
    // (xmlとViewHolderを紐付ける)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolderItem {

    }

    // B. position番号のデータをレイアウト(xml)に表示するようセット
    override fun getItemCount(): Int {

    }

    // C. データが何件あるかをカウントする
    override fun onBindViewHolder(holder: MatchViewHolderItem, position: Int) {

    }
}