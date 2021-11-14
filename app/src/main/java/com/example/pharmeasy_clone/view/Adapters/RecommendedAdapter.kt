package com.ranzan.pharmaeasyclone.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.Adapters.Interfaces.OnCategoryClick

class RecommendedAdapter(
    private val list: List<DataModel>,
    private val clickListener: OnCategoryClick
) :
    RecyclerView.Adapter<RecommendedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recommended_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position], clickListener)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val layout: LinearLayout = view.findViewById(R.id.recommendedLayout)
        private val img: ImageView = view.findViewById(R.id.dImage)
        private val name: TextView = view.findViewById(R.id.dText)
        private val price: TextView = view.findViewById(R.id.dPrice)

        fun setData(data: DataModel, onClickListener: OnCategoryClick) {
            Glide.with(img).load(data.img).placeholder(R.drawable.ic_broken_image).into(img)
            name.text = data.name
            price.text = "₹ ${data.price}"
            layout.setOnClickListener {
                onClickListener.detailedData(data)
            }
        }
    }
}