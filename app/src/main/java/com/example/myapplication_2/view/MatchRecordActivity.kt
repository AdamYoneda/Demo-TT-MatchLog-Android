package com.example.myapplication_2.view

import android.app.LauncherActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R
import com.example.myapplication_2.model.GameScores
import com.example.myapplication_2.model.Match
import com.example.myapplication_2.model.MatchType
import com.example.myapplication_2.model.Tournament

class MatchRecordActivity : AppCompatActivity() {
    // recyclerViewの変数を用意
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_record)

        // List
        val tournaments = listOf(
            Tournament(
                id = "1",
                date = "2023-09-01",
                tournamentName = "Summer Open 2023",
                matchType = MatchType.SINGLES,
                matches = listOf(
                    Match("1", 3, 2, "Player A", GameScores(11, 9, 8, 11, 11, 9, null, null, null, null, null, null, null, null), "Tough game"),
                    Match("2", 3, 0, "Player B", GameScores(11, 7, 11, 5, 11, 6, null, null, null, null, null, null, null, null), "Great performance"),
                    Match("3", 2, 3, "Player C", GameScores(9, 11, 11, 13, 7, 11, 11, 13, null, null, null, null, null, null), "Close match"),
                    Match("4", 3, 1, "Player D", GameScores(11, 5, 11, 7, 8, 11, 11, 7, null, null, null, null, null, null), "Strong finish"),
                    Match("5", 3, 2, "Player E", GameScores(10, 12, 11, 9, 9, 11, 11, 7, null, null, null, null, null, null), "Very close")
                )
            ),
            Tournament(
                id = "2",
                date = "2023-10-05",
                tournamentName = "Autumn Cup 2023",
                matchType = MatchType.DOUBLES,
                matches = listOf(
                    Match("6", 3, 1, "Team X", GameScores(11, 5, 11, 7, 8, 11, 11, 9, null, null, null, null, null, null), "Good teamwork"),
                    Match("7", 1, 3, "Team Y", GameScores(8, 11, 5, 11, 11, 8, 6, 11, null, null, null, null, null, null), "Tough defense"),
                    Match("8", 2, 3, "Team Z", GameScores(10, 12, 11, 9, 9, 11, 11, 7, 9, 11, null, null, null, null), "Nail-biting finish"),
                    Match("9", 3, 0, "Team A", GameScores(11, 6, 11, 8, 11, 9, null, null, null, null, null, null, null, null), "Comfortable win"),
                    Match("10", 3, 2, "Team B", GameScores(12, 10, 8, 11, 11, 7, 9, 11, null, null, null, null, null, null), "Close doubles match")
                )
            ),
            Tournament(
                id = "3",
                date = "2023-11-11",
                tournamentName = "Winter Showdown",
                matchType = MatchType.TEAM,
                matches = listOf(
                    Match("11", 3, 0, "Team Alpha", GameScores(11, 5, 11, 6, 11, 8, null, null, null, null, null, null, null, null), "Solid team effort"),
                    Match("12", 3, 2, "Team Beta", GameScores(11, 9, 7, 11, 11, 7, 9, 11, 11, 7, null, null, null, null), "Hard-fought victory"),
                    Match("13", 2, 3, "Team Gamma", GameScores(10, 12, 11, 9, 9, 11, 8, 11, 11, 9, null, null, null, null), "Lost in the last set"),
                    Match("14", 3, 1, "Team Delta", GameScores(11, 6, 8, 11, 11, 9, null, null, null, null, null, null, null, null), "Good coordination"),
                    Match("15", 3, 0, "Team Epsilon", GameScores(11, 5, 11, 6, 11, 8, null, null, null, null, null, null, null, null), "Convincing win")
                )
            ),
            Tournament(
                id = "4",
                date = "2023-12-20",
                tournamentName = "Year-End Championships",
                matchType = MatchType.SINGLES,
                matches = listOf(
                    Match("16", 3, 2, "Player F", GameScores(11, 9, 7, 11, 11, 9, 9, 11, null, null, null, null, null, null), "Tight match"),
                    Match("17", 3, 1, "Player G", GameScores(11, 7, 11, 9, 9, 11, null, null, null, null, null, null, null, null), "Dominated the game"),
                    Match("18", 2, 3, "Player H", GameScores(8, 11, 11, 13, 7, 11, 11, 13, null, null, null, null, null, null), "Lost narrowly"),
                    Match("19", 3, 0, "Player I", GameScores(11, 5, 11, 7, 11, 6, null, null, null, null, null, null, null, null), "Smooth performance"),
                    Match("20", 3, 2, "Player J", GameScores(12, 10, 8, 11, 11, 7, 9, 11, null, null, null, null, null, null), "Epic comeback")
                )
            ),
            // 以下、同じようにデータを追加
            Tournament(
                id = "5",
                date = "2024-01-15",
                tournamentName = "New Year Kickoff",
                matchType = MatchType.SINGLES,
                matches = listOf(
                    Match("21", 3, 1, "Player K", GameScores(11, 7, 9, 11, 11, 8, null, null, null, null, null, null, null, null), "Strong start"),
                    Match("22", 2, 3, "Player L", GameScores(10, 12, 11, 9, 11, 8, 9, 11, null, null, null, null, null, null), "Close loss"),
                    Match("23", 3, 0, "Player M", GameScores(11, 5, 11, 7, 11, 6, null, null, null, null, null, null, null, null), "Great control"),
                    Match("24", 3, 2, "Player N", GameScores(9, 11, 11, 9, 8, 11, 11, 9, null, null, null, null, null, null), "Great rally"),
                    Match("25", 3, 0, "Player O", GameScores(11, 5, 11, 6, 11, 8, null, null, null, null, null, null, null, null), "Quick win")
                )
            )
            // 続いて6～10のTournamentを同じパターンで追加
        )


        // recyclerViewを表示させる
        recyclerView = findViewById(R.id.recyclerView) // idの取得
        recyclerView.adapter = MatchRecordAdapter(tournaments) // アダプターをセット
        recyclerView.layoutManager = LinearLayoutManager(this) // 各アイテムを縦に並べるように指示
    }
}