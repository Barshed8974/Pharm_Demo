package com.example.pharmeasy_clone.view.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.view.HomeViewModel
import kotlinx.android.synthetic.main.activity_all_categories.*

class CategoriesActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_categories)
        //back button press
        back.setOnClickListener {
            onBackPressed()
        }
        //Setting TOp title
        if (intent != null) {
            val cate = intent.getStringExtra("category")
            topTitle.text = cate
        }
        val list = homeViewModel.getDetailedList()

    }
}