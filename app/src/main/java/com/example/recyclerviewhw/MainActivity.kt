package com.example.recyclerviewhw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var amountOfPlayers: Int = 3

        var rv: RecyclerView = findViewById(R.id.rvPlayer)
        var btnEkle = findViewById<Button>(R.id.btnEkle)
        var btnCikar = findViewById<Button>(R.id.btnCikar)

        var player1 = Player("Lionel Messi","Sağ Kanat",35, "https://img.a.transfermarkt.technology/portrait/big/28003-1671435885.jpg?lm=1")
        var player2 = Player("Rodrigo de Paul","Merkez Orta Saha",28, "https://img.a.transfermarkt.technology/portrait/big/255901-1623838716.jpg?lm=1")
        var player3 = Player("Emiliano Martinez","Kaleci",30, "https://img.a.transfermarkt.technology/portrait/big/111873-1668180824.jpg?lm=1")
        var player4 = Player("Lionel Messi","Sağ Kanat",35, "https://img.a.transfermarkt.technology/portrait/big/28003-1671435885.jpg?lm=1")
        var player5 = Player("Rodrigo de Paul","Merkez Orta Saha",28, "https://img.a.transfermarkt.technology/portrait/big/255901-1623838716.jpg?lm=1")
        var player6 = Player("Emiliano Martinez","Kaleci",30, "https://img.a.transfermarkt.technology/portrait/big/111873-1668180824.jpg?lm=1")

        var playerList = arrayListOf(player1,player2,player3)

        var playerAdapter: PlayerAdapter = PlayerAdapter(playerList)

        btnEkle.setOnClickListener() {
            playerList.add(player4)
            playerAdapter = PlayerAdapter(playerList)
            rv.adapter = playerAdapter
            rv.layoutManager = LinearLayoutManager(this)
        }

        btnCikar.setOnClickListener() {
            playerList.remove(player4)
            playerAdapter = PlayerAdapter(playerList)
            rv.adapter = playerAdapter
            rv.layoutManager = LinearLayoutManager(this)
        }

        rv.adapter = playerAdapter
        rv.layoutManager = LinearLayoutManager(this)

    }

}