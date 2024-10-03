package com.example.myapplication_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R

class RecyclerAdapter : RecyclerView.Adapter<MatchViewHolderItem>() {
    // 表示するリストを用意
    private val animalList = listOf(
        "ライオン", "ゾウ", "キリン", "トラ", "チーター", "シマウマ", "カバ",
        "サイ", "ゴリラ", "チンパンジー", "オオカミ", "キツネ", "リス",
        "イヌ", "ネコ", "ウサギ", "タヌキ", "クマ", "ヒョウ", "コアラ",
        "カンガルー", "ペンギン", "ワシ", "タカ", "フクロウ", "ワニ",
        "イルカ", "クジラ", "サメ", "クラゲ"
    )

    // A. 1行分のレイアウト(View)を生成
    // (xmlとViewHolderを紐付ける)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolderItem {
        // xmlのレイアウトを取得(インフレート)
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_layout, parent, false)
        return MatchViewHolderItem(itemXml)
    }

    // B. position番号のデータをレイアウト(xml)に表示するようセット
    override fun onBindViewHolder(holder: MatchViewHolderItem, position: Int) {
        holder.itemName.text = animalList[position]
    }

    // C. データが何件あるかをカウントする
    override fun getItemCount(): Int {
        return animalList.size
    }
}