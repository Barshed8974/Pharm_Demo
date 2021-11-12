package com.example.pharmeasy_clone.view.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.DataModel
import kotlinx.android.synthetic.main.activity_detailed_view.*

class DetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)
        if (intent != null) {
            val data = intent.getParcelableExtra<DataModel>("data")
            data!!.apply {
                detailedDescription.text = description
            }
        }
    }
}