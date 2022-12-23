package com.example.recyclerviewhw

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class PlayerAdapter2 (
    val playerList: ArrayList<Player>,
    val userClickListener: (Player) -> Unit
    ) : RecyclerView.Adapter<PlayerAdapter2.PlayerViewHolder> () {

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtName: TextView? = null
        var txtPosition: TextView? = null
        var txtAge: TextView? = null
        var imgPlayer: ImageView

        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtPosition = itemView.findViewById(R.id.txtPosition)
            txtAge = itemView.findViewById(R.id.txtAge)
            imgPlayer = itemView.findViewById(R.id.imgPlayer)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_player_item,parent,false)
        return PlayerViewHolder(view)

    }

    override fun getItemCount(): Int = playerList.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {

        val currentPlayer: Player = playerList[position]
        holder.txtName?.text = currentPlayer.name
        holder.txtPosition?.text = currentPlayer.position
        holder.txtAge?.text = currentPlayer.age.toString()
        Glide.with(holder.itemView).load(currentPlayer.url).into(holder.imgPlayer)

        holder.itemView.rootView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${currentPlayer.age.toString()}", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.rootView.setOnClickListener {
            userClickListener(currentPlayer)
        }

    }
}