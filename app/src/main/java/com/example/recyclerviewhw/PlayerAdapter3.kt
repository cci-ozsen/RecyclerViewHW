package com.example.recyclerviewhw

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class PlayerAdapter3 (val playerList: ArrayList<Player>,val onClickLister: RowClickListener<Player>) : RecyclerView.Adapter<PlayerAdapter3.PlayerViewHolder> () {

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtName: TextView? = null
        var txtPosition: TextView? = null
        var txtAge: TextView? = null
        var imgPlayer: ImageView
        var btnEkle: Button
        var btnCikar: Button

        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtPosition = itemView.findViewById(R.id.txtPosition)
            txtAge = itemView.findViewById(R.id.txtAge)
            imgPlayer = itemView.findViewById(R.id.imgPlayer)
            btnEkle = itemView.findViewById(R.id.btnEkle)
            btnCikar = itemView.findViewById(R.id.btnCikar)
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

    }
    fun onClickPlayerAdd (playerList: ArrayList<Player> ) {
        this.playerList.clear()
        this.playerList.addAll(playerList)
        notifyDataSetChanged()
    }
}