package com.example.pharmeasy_clone.view.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
import com.example.pharmeasy_clone.view.Adapters.Interfaces.CartOnClick

class CartAdapter(var list: List<RoomEntity>, private val cartOnClick: CartOnClick) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)
        return CartViewHolder(view)

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.setData(list[position], cartOnClick)
    }

    override fun getItemCount(): Int = list.size


    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val cartImage: ImageView = view.findViewById(R.id.cartImage)
        private val cartName: TextView = view.findViewById(R.id.cartName)
        private val cartShot: TextView = view.findViewById(R.id.cartShort)
        private val cartPrice: TextView = view.findViewById(R.id.cartPrice)
        private val delete: ImageButton = view.findViewById(R.id.imageButton)
        private val layout: ConstraintLayout = view.findViewById(R.id.layout)
        fun setData(data: RoomEntity, cartOnClick: CartOnClick) {
            data.apply {
//                cartImage.setImageResource(data.img)
//                cartName.text = name
//                cartShot.text = shortDescription
//                cartPrice.text = "₹ $price"
                delete.setOnClickListener {
                    cartOnClick.onDelete(data)
                }
                layout.setOnClickListener {
                    cartOnClick.onClick(data)
                }
            }

        }
    }

}