package com.example.gridview_with_images_app

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val gridView = findViewById<GridView>(R.id.gridView)

        val namePricePairs = listOf(
            "Apple" to "$1.99",
            "Banana" to "$0.99",
            "Orange" to "$2.29",
            "Strawberry" to "$3.99",
            "Grapes" to "$2.49",
            "Mango" to "$1.89",
            "Pineapple" to "$3.29",
            "Kiwi" to "$2.79",
            "Watermelon" to "$4.99",
            "Blueberry" to "$3.49",
            "Peach" to "$2.39",
            "Cherry" to "$3.59"
        )

        val imageIds = listOf(
            R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.strawberry,
            R.drawable.grapes, R.drawable.mango, R.drawable.pineapple, R.drawable.kiwi,
            R.drawable.watermelon, R.drawable.blueberry, R.drawable.peach, R.drawable.cherry
        )

        val fruitList = namePricePairs.mapIndexed { index, pair ->
            FruitItem(imageIds[index], pair.first, pair.second)
        }

        val adapter = FruitAdapter(this, fruitList)
        gridView.adapter = adapter

    }
}