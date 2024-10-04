package com.example.myapplication_2.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R
import com.example.myapplication_2.model.Tournament

class TournamentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(tournament: Tournament) {
        // 各大会のデータをバインド
        itemView.findViewById<TextView>(R.id.tournament_name).text = tournament.tournamentName
        itemView.findViewById<TextView>(R.id.tournament_date).text = tournament.date
    }
}