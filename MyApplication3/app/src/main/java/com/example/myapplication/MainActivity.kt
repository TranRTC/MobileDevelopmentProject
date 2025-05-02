package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager



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

        // Step 1: Find the RecyclerView by ID
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Step 2: Create your list of image resource IDs from drawable
        val imageList = listOf(
            R.drawable.pic_1,
            R.drawable.pic_2,
            R.drawable.pict_3,
            R.drawable.pict_4,
            R.drawable.pict_5,
            R.drawable.pict_6

        )


        val captionList = listOf(

            getString(R.string.pic1_name),
            getString(R.string.pic2_name),
            getString(R.string.pic3_name),
            getString(R.string.pic4_name),
            getString(R.string.pic5_name),
            getString(R.string.pic6_name),

        )


        // Step 3: Create your adapter and plug it into the RecyclerView
        val adapter = ImageAdapter(imageList, captionList)  // We'll build this adapter next

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter




    }
}