package com.example.myapplication_2.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R
import com.example.myapplication_2.model.Match

class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(match: Match) {
        // 試合のデータをバインド
        itemView.findViewById<TextView>(R.id.opponent_name).text = match.opponentName
        itemView.findViewById<TextView>(R.id.score).text =
            "${match.playerScore} - ${match.opponentScore}"
    }
}