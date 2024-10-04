package com.example.myapplication_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R
import com.example.myapplication_2.model.Match
import com.example.myapplication_2.model.Tournament

class MatchRecordAdapter(private val tournaments: List<Tournament>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_TOURNAMENT = 0
        private const val VIEW_TYPE_MATCH = 1
    }

    override fun getItemViewType(position: Int): Int {
        // 位置に応じてTournamentかMatchかを判断
        return if (isTournamentPosition(position)) VIEW_TYPE_TOURNAMENT else VIEW_TYPE_MATCH
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_TOURNAMENT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.tournament_item, parent, false)
                TournamentViewHolder(view)
            }
            VIEW_TYPE_MATCH -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.match_item, parent, false)
                MatchViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return getTotalItemCount()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TournamentViewHolder) {
            // Tournamentデータをバインド
            holder.bind(tournaments[getTournamentIndex(position)])
        } else if (holder is MatchViewHolder) {
            // Matchデータをバインド
            holder.bind(getMatchAtPosition(position))
        }
    }


    // サポート関数を追加（位置判定やデータ取得など）
    private fun isTournamentPosition(position: Int): Boolean {
        // 大会セクションかどうかを判断
        // 実装に合わせて判定ロジックを実装する
    }

    private fun getTournamentIndex(position: Int): Int {
        // positionに基づいて対応するTournamentのインデックスを返す
    }

    private fun getMatchAtPosition(position: Int): Match {
        // positionに基づいて対応するMatchを返す
    }

    private fun getTotalItemCount(): Int {
        // Tournament + Matchの合計数を計算
    }
}