package com.example.pharmeasy_clone.view.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.CategoryModel
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.Adapters.Interfaces.OnCategoryClick
import com.example.pharmeasy_clone.view.HomeViewModel
import com.ranzan.pharmaeasyclone.View.Adapters.CategoryAdapter
import kotlinx.android.synthetic.main.activity_category.*

class AllCategoryActivity : AppCompatActivity(), OnCategoryClick {
    private val homeViewModel: HomeViewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setCategoryRecyclerView(homeViewModel.getCategory())
        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setCategoryRecyclerView(list: List<CategoryModel>) {
        val categoryAdapter = CategoryAdapter(list, this, R.layout.allcateogry_item_layout)
        allCategoryRecyclerView.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun categoryData(category: String) {
        val intent = Intent(AllCategoryActivity@ this, CategoriesActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    override fun detailedData(data: DataModel) {

    }

}