package com.example.gridview_with_images_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(private val context: Context, private val itemList: List<FruitItem>) : BaseAdapter() {

    override fun getCount(): Int = itemList.size

    override fun getItem(position: Int): Any = itemList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)

        val item = itemList[position]
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val nameView = view.findViewById<TextView>(R.id.nameView)
        val priceView = view.findViewById<TextView>(R.id.priceView)

        imageView.setImageResource(item.fruit_id)
        nameView.text = item.fruit_name
        priceView.text = item.fruit_price

        return view
    }
}