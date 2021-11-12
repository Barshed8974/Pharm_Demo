package com.example.pharmeasy_clone.view.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.CategoryModel
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.HomeViewModel
import com.ranzan.pharmaeasyclone.View.Adapters.CategoryAdapter
import com.ranzan.pharmaeasyclone.View.Adapters.DetailAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel = HomeViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCategoryRecyclerView(homeViewModel.getCategory())
        setDetailedRecyclerView(homeViewModel.getDetailedList())
    }

    private fun setDetailedRecyclerView(list: List<DataModel>) {
        val detailAdapter = DetailAdapter(list)
        recommendedRecyclerView.adapter=detailAdapter
        recommendedRecyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
    }

    private fun setCategoryRecyclerView(list: List<CategoryModel>) {
        val categoryAdapter = CategoryAdapter(list)
        categoryRecyclerView.adapter = categoryAdapter
        categoryRecyclerView.layoutManager = GridLayoutManager(context, 4)
    }


}