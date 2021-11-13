package com.example.pharmeasy_clone.view.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
import com.example.pharmeasy_clone.ViewModel.RoomDBViewModel
import com.example.pharmeasy_clone.view.Adapters.CartAdapter
import com.example.pharmeasy_clone.view.Adapters.Interfaces.CartOnClick
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity(), CartOnClick {
    private lateinit var roomDBViewModel: RoomDBViewModel
    private lateinit var list: List<RoomEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        roomDBViewModel = RoomDBViewModel(this)

        roomDBViewModel.getCartData().observe(this, Observer {
            list = it
            setCartRecyclerView(list)

        })
    }

    private fun setCartRecyclerView(list: List<RoomEntity>) {
        val cartAdapter = CartAdapter(list, this)
        cartRecyclerView.apply {
            adapter = cartAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDelete(roomEntity: RoomEntity) {
        roomDBViewModel.insertData(roomEntity)
    }

    override fun onClick(roomEntity: RoomEntity) {
        roomDBViewModel.getCartItem(roomEntity.id!!)
    }
}