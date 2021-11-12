package com.ranzan.pharmaeasyclone.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.CategoryModel

class CategoryAdapter(private val list: List<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shop_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var img: ImageView = view.findViewById(R.id.categoryImage)
        private var t: TextView = view.findViewById(R.id.categoryText)

        fun setData(data: CategoryModel) {
            img.setImageResource(data.img)
            t.text = data.name
        }
    }
}