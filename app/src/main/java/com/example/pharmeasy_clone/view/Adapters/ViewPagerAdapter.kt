package com.example.pharmeasy_clone.view.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.pharmeasy_clone.R


class ViewPagerAdapter(var list: List<String>, val viewPager: ViewPager2) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.viewpager_layout, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(list[position])
        if (position == list.size - 2)
            viewPager.post(run)
    }

    override fun getItemCount(): Int = list.size

    class ViewPagerViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.viewPagerImage)
        fun setData(img: String) {
            Glide.with(image).load(img).placeholder(R.drawable.ic_broken_image).into(image)
        }
    }

    private val run = Runnable {
        list = list + list
        notifyDataSetChanged()
    }

}