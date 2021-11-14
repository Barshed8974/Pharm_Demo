package com.example.pharmeasy_clone.view.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
import com.example.pharmeasy_clone.ViewModel.RoomDBViewModel
import com.example.pharmeasy_clone.view.Adapters.CartAdapter
import com.example.pharmeasy_clone.view.Adapters.Interfaces.CartOnClick
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

        placeOrder.setOnClickListener {
            startActivity(Intent(CartActivity@ this, PlaceOrderActivity::class.java))
        }
    }

    private fun setCartRecyclerView(list: List<RoomEntity>) {
        val cartAdapter = CartAdapter(list, this)
        cartRecyclerView.apply {
            adapter = cartAdapter
            layoutManager = LinearLayoutManager(context)
        }

        var total = 0
        for (item: RoomEntity in list) {
            total += item.price * item.quantity
        }
        totalPrice.text = total.toString()
    }

    override fun onDelete(roomEntity: RoomEntity) {
        roomDBViewModel.deleteData(roomEntity)
        Toast.makeText(applicationContext, "Removed from Cart", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(roomEntity: RoomEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = roomDBViewModel.getCartItem(roomEntity.id!!)
            goToDetailedView(data)
        }
    }

    private fun goToDetailedView(data: RoomEntity) {
        val intent = Intent(CartActivity@ this, DetailedViewActivity::class.java)
        val d: DataModel
        data.apply {
            d = DataModel(price, name, img, category, description)
        }
        intent.putExtra("data", d)
        startActivity(intent)
    }
}