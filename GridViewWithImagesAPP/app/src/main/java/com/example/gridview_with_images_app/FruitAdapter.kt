package com.example.gridview_with_images_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(
    private val context: Context,
    private val fruitList: List<FruitItem>
) : BaseAdapter() {

    override fun getCount(): Int = fruitList.size

    override fun getItem(position: Int): Any = fruitList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        }

        val fruitItem = fruitList[position]

        val imageView = view!!.findViewById<ImageView>(R.id.imageView)
        val explanationView = view.findViewById<TextView>(R.id.explanationView)
        val dataView = view.findViewById<TextView>(R.id.dataView)

        imageView.setImageResource(fruitItem.imageResId)
        explanationView.text = fruitItem.name
        dataView.text = fruitItem.price

        return view
    }
}