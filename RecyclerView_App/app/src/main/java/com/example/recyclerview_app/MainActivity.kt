package com.example.recyclerview_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // create the data list with images store in "drawable" and name in string.xml
        val items = listOf(

            ImageItem(R.drawable.pic_1, getString(R.string.pic1_name)),
            ImageItem(R.drawable.pic_2, getString(R.string.pic2_name)),
            ImageItem(R.drawable.pict_3, getString(R.string.pic3_name)),
            ImageItem(R.drawable.pict_4, getString(R.string.pic4_name)),
            ImageItem(R.drawable.pict_5, getString((R.string.pic5_name)))

        )

        // setup RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageAdapter(itemList = items)


    }
}