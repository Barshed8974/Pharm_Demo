package com.example.pharmeasy_clone.view.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.Database.DataModel
import com.example.pharmeasy_clone.view.Adapters.Interfaces.GetDetails
import com.example.pharmeasy_clone.view.HomeViewModel
import com.ranzan.pharmaeasyclone.View.Adapters.DetailAdapter
import kotlinx.android.synthetic.main.activity_all_categories.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.back
import kotlinx.android.synthetic.main.activity_search.sortBtn

class SearchActivity : AppCompatActivity(), GetDetails {
    private val homeViewModel: HomeViewModel = HomeViewModel()
    private lateinit var list: ArrayList<DataModel>
    private lateinit var sAdapter: DetailAdapter
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        list = homeViewModel.getDetailedList()
        setAllData(list)

        back.setOnClickListener {
            onBackPressed()
        }
        searchBar.setOnClickListener {
            searchBar.isIconified = false
        }
        searchData()
        sortBtn.setOnClickListener {
            if (i == 0) i = 1
            if (i == 1) {
                list.sortBy { it.price }
                setAllData(list)
                i = 2
            } else {
                list.sortByDescending { it.price }
                setAllData(list)
                i = 1
            }
        }
    }

    private fun searchData() {
        val modifiedList = ArrayList<DataModel>()
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (!query.isNullOrEmpty()) {
                    setAllData(list)
                } else {
                    for (item: DataModel in list) {
                        if (item.name.contains(query) || item.category.contains(query)) {
                            modifiedList.add(item)
                        }
                    }
                    if (modifiedList.size == 0) {
                        Toast.makeText(this@SearchActivity, "No Match Found", Toast.LENGTH_SHORT)
                            .show()
                    }
                    sAdapter.updateData(modifiedList)
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                for (item: DataModel in list) {
                    if (item.name.contains(newText) || item.category.contains(newText))
                        modifiedList.add(item)
                }
                sAdapter.updateData(modifiedList)
                return false
            }
        })
    }

    private fun setAllData(list: ArrayList<DataModel>) {
        sAdapter = DetailAdapter(list, this)
        searchActivityRV.apply {
            adapter = sAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun getDetailedView(data: DataModel) {
        val intent = Intent(SearchActivity@ this, DetailedViewActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }
}