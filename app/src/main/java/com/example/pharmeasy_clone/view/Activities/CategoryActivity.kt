package com.example.pharmeasy_clone.view.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.Adapters.Interfaces.GetDetails
import com.example.pharmeasy_clone.view.HomeViewModel
import com.ranzan.pharmaeasyclone.View.Adapters.DetailAdapter
import kotlinx.android.synthetic.main.activity_all_categories.*
import kotlinx.android.synthetic.main.activity_all_categories.back
import kotlinx.android.synthetic.main.activity_all_categories.ivCart
import kotlinx.android.synthetic.main.activity_all_categories.ivSearch
import kotlinx.android.synthetic.main.activity_detailed_view.*

class CategoryActivity : AppCompatActivity(), GetDetails {
    private val homeViewModel: HomeViewModel = HomeViewModel()
    private lateinit var cate: String
    lateinit var list: List<DataModel>
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_categories)
        //back button press
        back.setOnClickListener {
            onBackPressed()
        }
        //Setting TOp title
        if (intent != null) {
            cate = intent.getStringExtra("category").toString()
            topTitle.text = cate
        }
        list = homeViewModel.getDetailedList()
        setRecyclerView(list)
        ivCart.setOnClickListener {
            startActivity(Intent(CategoryActivity@ this, CartActivity::class.java))
        }
        ivSearch.setOnClickListener {
            startActivity(Intent(CategoryActivity@ this, SearchActivity::class.java))
        }
        sortBtn.setOnClickListener {
            if (i == 0) i = 1
            if (i == 1) {
                list = list.sortedBy { it.price }
                setRecyclerView(list)
                i = 2
            } else {
                list = list.sortedByDescending { it.price }
                setRecyclerView(list)
                i = 1
            }
        }

    }

    private fun setRecyclerView(list: List<DataModel>) {
        var updatedList = ArrayList<DataModel>()
        list.forEach {
            if (it.category == cate)
                updatedList.add(it)
        }
        list[0].category
        val recyclerAdapter = DetailAdapter(updatedList, this)
        categoryRecycler.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun getDetailedView(data: DataModel) {
        val intent = Intent(CategoryActivity@ this, DetailedViewActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }
}