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
import com.example.pharmeasy_clone.view.Adapters.Interfaces.GetDetails

class DetailAdapter(private var list: ArrayList<DataModel>, private val getDetails: GetDetails) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cateogry_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position], getDetails)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val img: ImageView = view.findViewById(R.id.dImage)
        private val name: TextView = view.findViewById(R.id.dText)
        private val price: TextView = view.findViewById(R.id.dPrice)
        private val layout: LinearLayout = view.findViewById(R.id.dLayout)
        fun setData(data: DataModel, getDetails: GetDetails) {
            Glide.with(img).load(data.img)
                .placeholder(R.drawable.ic_broken_image).into(img)
            name.text = data.name
            price.text = "₹ ${data.price}"

            layout.setOnClickListener {
                getDetails.getDetailedView(data)
            }
        }
    }

    fun updateData(updatedList: ArrayList<DataModel>) {
        list.clear()
        list = updatedList
        notifyDataSetChanged()
    }
}