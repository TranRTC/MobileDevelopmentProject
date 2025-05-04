package com.example.gridview_with_images_app

//2. Data Class: FruitItem

data class FruitItem(
    val fruit_id: Int,         // Image resource ID (e.g., R.drawable.pic1)
    val fruit_name: String,    // Name of the fruit
    val fruit_price: String    // Price of the fruit
)
