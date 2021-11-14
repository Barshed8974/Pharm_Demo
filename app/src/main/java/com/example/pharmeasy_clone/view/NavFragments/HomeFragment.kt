package com.example.pharmeasy_clone.view.NavFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.CategoryModel
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.Activities.AllCategoriesViewActivity
import com.example.pharmeasy_clone.view.Activities.CartActivity
import com.example.pharmeasy_clone.view.Activities.CategoryActivity
import com.example.pharmeasy_clone.view.Activities.DetailedViewActivity
import com.example.pharmeasy_clone.view.Adapters.Interfaces.OnCategoryClick
import com.example.pharmeasy_clone.view.Adapters.ViewPagerAdapter
import com.example.pharmeasy_clone.view.HomeViewModel
import com.ranzan.pharmaeasyclone.View.Adapters.CategoryAdapter
import com.ranzan.pharmaeasyclone.View.Adapters.RecommendedAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), OnCategoryClick {
    private val homeViewModel: HomeViewModel = HomeViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBannerAdsPageViewer(homeViewModel.getBanner())
        setCategoryRecyclerView(homeViewModel.getCategory())
        setDetailedRecyclerView(homeViewModel.getDetailedList())
        Glide.with(getPlus)
            .load("https://cms-contents.pharmeasy.in/banner/0ff77f182b8-UPDATEDKBCDWEB.jpg")
            .into(getPlus)
        //view all categories

        categoryViewAll.setOnClickListener {
            startActivity(Intent(context, AllCategoriesViewActivity::class.java))
        }

        ivCart.setOnClickListener {
            startActivity(Intent(context, CartActivity::class.java))
        }
    }

    private fun setBannerAdsPageViewer(banner: List<String>) {
        val viewPagerAdapter = ViewPagerAdapter(banner, ads)
        ads2.adapter = viewPagerAdapter
        ads.apply {
            adapter = viewPagerAdapter
            clipToPadding = false;
            clipChildren = false;
            offscreenPageLimit = 3;
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER;
        }

    }

    private fun setDetailedRecyclerView(list: List<DataModel>) {
        val l = mutableListOf<DataModel>()
        for (i in 0..10) {
            val d = (list.indices).random()
            l.add(list[d])
        }
        val recommendedAdapter = RecommendedAdapter(l.distinct(), this)
        recommendedRecyclerView.apply {
            adapter = recommendedAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun setCategoryRecyclerView(list: List<CategoryModel>) {

        val categoryAdapter = CategoryAdapter(list, this, R.layout.shop_category_item)
        categoryRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(context, 4)
        }
    }

    override fun categoryData(category: String) {
        val intent = Intent(context, CategoryActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    override fun detailedData(data: DataModel) {
        val intent = Intent(context, DetailedViewActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }
}