package com.ranzan.pharmaeasyclone.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.CategoryModel
import com.example.pharmeasy_clone.view.Adapters.OnClickListener

class CategoryAdapter(
    private val list: List<CategoryModel>,
    private val onClickListener: OnClickListener,
    val layout: Int
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position], onClickListener)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var img: ImageView = view.findViewById(R.id.categoryImage)
        private var text: TextView = view.findViewById(R.id.categoryText)
        private var layout:LinearLayout=view.findViewById(R.id.categoryLayout)
        fun setData(data: CategoryModel,onClickListener: OnClickListener) {
            img.setImageResource(data.image)
            text.text = data.category
            layout.setOnClickListener{
                onClickListener.onClicked(data.category)
            }
        }
    }
}