package com.example.pharmeasy_clone.view.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        roomDBViewModel = RoomDBViewModel(this)

        back.setOnClickListener {
            onBackPressed()
        }

        if (intent != null) {
            data = intent.getParcelableExtra<DataModel>("data")!!
            data!!.apply {
                detailedDescription.text = description
                detailedPrice.text = "₹ ${data.price}"
                detailedName.text = name
                detailedUses.text = uses
                detailedImage.setImageResource(data.img)
                detailedKeyBenefits.text = keyBenefits
                dShortDescription.text = shortDescription
            }
        }
        addToCart.setOnClickListener {
            val roomEntity = RoomEntity(
                100, "Name", R.drawable.img, "Ca", "sD",
                "D",
                "K", "use",
                1
            )
            roomDBViewModel.insertData(roomEntity)
        }
    }
}