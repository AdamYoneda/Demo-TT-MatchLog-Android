package com.example.myapplication_2.presentation.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_2.R

// match_layout.xmlのViewHolder
class MatchViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // View(xml)の方から、指定のidを見つけてくる("@+id/textView")
    val itemName: TextView = itemView.findViewById(R.id.textView)

}