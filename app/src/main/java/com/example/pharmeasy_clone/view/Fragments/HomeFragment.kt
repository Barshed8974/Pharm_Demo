package com.example.pharmeasy_clone.view.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.view.HomeViewModel
import com.example.pharmeasy_clone.view.MedicalItem


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel = HomeViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = homeViewModel.fetchApi()
        setRecyclerView(list)
    }

    private fun setRecyclerView(list: List<MedicalItem?>) {

    }

}