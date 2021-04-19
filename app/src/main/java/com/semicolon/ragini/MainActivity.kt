package com.semicolon.ragini

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    val list = listOf(
            R.drawable.song1,
            R.drawable.song2,
            R.drawable.song3,
            R.drawable.song4,
            R.drawable.song5,
            R.drawable.song6,
            R.drawable.song7,
            R.drawable.song8,
            R.drawable.song9,
            R.drawable.song10
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = GridAdapter(list)
        //val button: Button = findViewById(R.id.button)
        //button.setOnClickListener {
          //  val intent = Intent(this, SongPage::class.java)
           // startActivity(intent)
        //}
    }
}