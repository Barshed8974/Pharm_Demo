package com.example.pharmeasy_clone.view.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
import com.example.pharmeasy_clone.ViewModel.RoomDBViewModel
import kotlinx.android.synthetic.main.activity_detailed_view.*

class DetailedViewActivity : AppCompatActivity() {
    private lateinit var roomDBViewModel: RoomDBViewModel
    private lateinit var data: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)
        roomDBViewModel = RoomDBViewModel(this@DetailedViewActivity)

        back.setOnClickListener {
            onBackPressed()
        }
        ivCart.setOnClickListener {
            startActivity(Intent(DetailedViewActivity@ this, CartActivity::class.java))
        }
        ivSearch.setOnClickListener {
            startActivity(Intent(DetailedViewActivity@ this, SearchActivity::class.java))
        }
        if (intent != null) {
            data = intent.getParcelableExtra<DataModel>("data")!!
            data!!.apply {
                detailedDescription.text = description
                detailedPrice.text = "₹ ${data.price}"
                detailedName.text = name
                detailedCategory.text = category
                Glide.with(applicationContext).load(data.img)
                    .placeholder(R.drawable.ic_broken_image).into(detailedImage)
            }
        }
        addToCart.setOnClickListener {
            data.apply {
                val roomEntity = RoomEntity(price, name, img, category, description, 1)
                roomDBViewModel.insertData(roomEntity)
            }
            addToCart.text = "Added To Cart"
            Toast.makeText(applicationContext, "Added To Cart", Toast.LENGTH_SHORT).show()
            addToCart
            addToCart.isClickable = false
        }
    }
}