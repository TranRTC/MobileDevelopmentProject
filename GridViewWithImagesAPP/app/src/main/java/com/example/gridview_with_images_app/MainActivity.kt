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

        val fruitList = listOf(
            FruitItem(R.drawable.apple_image, getString(R.string.apple_name), getString(R.string.apple_price)),
            FruitItem(R.drawable.banana_image, getString(R.string.banana_name), getString(R.string.banana_price)),
            FruitItem(R.drawable.cherry_image, getString(R.string.cherry_name), getString(R.string.cherry_price))
        )

        val adapter = FruitAdapter(this, fruitList)
        gridView.adapter = adapter
    }
}