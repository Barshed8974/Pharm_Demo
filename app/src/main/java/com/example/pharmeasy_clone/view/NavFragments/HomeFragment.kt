package com.example.pharmeasy_clone.view.NavFragments

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.CategoryModel
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.Activities.AllCategoryActivity
import com.example.pharmeasy_clone.view.Activities.CategoriesActivity
import com.example.pharmeasy_clone.view.Activities.DetailedViewActivity
import com.example.pharmeasy_clone.view.Adapters.Interfaces.OnCategoryClick
import com.example.pharmeasy_clone.view.HomeViewModel
import com.ranzan.pharmaeasyclone.View.Adapters.CategoryAdapter
import com.ranzan.pharmaeasyclone.View.Adapters.RecommendedAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), OnCategoryClick {
    private val homeViewModel: HomeViewModel = HomeViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCategoryRecyclerView(homeViewModel.getCategory())
        setDetailedRecyclerView(homeViewModel.getDetailedList())

        //view all categories
        categoryViewAll.setOnClickListener {
            startActivity(Intent(context, AllCategoryActivity::class.java))
        }
    }

    private fun setDetailedRecyclerView(list: List<DataModel>) {
        val recommendedAdapter = RecommendedAdapter(list)
        recommendedRecyclerView.apply {
            adapter = recommendedAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun setCategoryRecyclerView(list: List<CategoryModel>) {
        val categoryAdapter = CategoryAdapter(list, this,R.layout.shop_category_item)
        categoryRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(context, 4)
        }
    }

    override fun categoryData(category: String) {
        val intent = Intent(context, CategoriesActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    override fun detailedData(data: DataModel) {
        val intent = Intent(context, DetailedViewActivity::class.java)
        intent.putExtra(
            "data",
            (Parcelable) data
        )

    }


}