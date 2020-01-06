package com.mourad.gamebacklog.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mourad.gamebacklog.R
import com.mourad.gamebacklog.entity.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    lateinit var context: Context

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        private val tvReminder: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(game: Game) {
            itemView.tvGameTitle.text = game.title
            itemView.tvPlatform.text = game.platform

            val format = SimpleDateFormat("dd MMMM yyyy")
            itemView.tvRelease.text = context.getString(R.string.release_date, format.format(game.releaseDate))
        }
    }
}