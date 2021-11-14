package com.example.pharmeasy_clone.view


import com.example.pharmeasy_clone.Value
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.myapplication.Repo.FirebaseCallback
import com.example.pharmeasy_clone.CartData.CartDB
import com.example.pharmeasy_clone.CartData.DAO
import com.example.pharmeasy_clone.FirebasbeModel.ResponseFB
import com.example.pharmeasy_clone.FirebasbeModel.model
import com.example.pharmeasy_clone.view.NavFragments.AccountFragment
import com.example.pharmeasy_clone.view.NavFragments.HealthCareFragment
import com.example.pharmeasy_clone.view.NavFragments.HomeFragment
import com.example.pharmeasy_clone.view.NavFragments.LabTestsFragment
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.Repository.CartRepo.MyCartRepo
import com.example.pharmeasy_clone.ViewModel.CartViewModel.CartViewModel
import com.example.pharmeasy_clone.ViewModel.Firebase.CreateUser
import com.example.pharmeasy_clone.ViewModel.Firebase.getData
import com.example.pharmeasy_clone.view.NavFragments.NotificationsFragment
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: getData
    var TAG="TAG"
    lateinit var repository : MyCartRepo
    lateinit var cartDAO: DAO
    lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(getData::class.java)

        Log.d("Ami",Value.getNum()!!)
        //intitialize dao
        cartDAO=CartDB.getDatabaseObject(this).getTaskDAO()
        repository= MyCartRepo(cartDAO)
        cartViewModel= CartViewModel(repository)


        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.home))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.healthcare))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.diagnosis))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_user))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.account))

        bottomNavigation.setOnShowListener {
            var fragment: Fragment? = null
            when (it.id) {
                0 -> fragment= HomeFragment()
                1 -> fragment = HealthCareFragment()
                2 -> fragment = LabTestsFragment()
                3 -> fragment = NotificationsFragment()
                4 -> fragment = AccountFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment!!)
                .commit()
        }

        bottomNavigation.show(0, true)
        bottomNavigation.setOnClickMenuListener {
            bottomNavigation.show(it.id, true)
        }
    }


    private fun retriveData() {
        viewModel.getResponseUsingCallback(object : FirebaseCallback {
            override fun onResponse(responseFB: ResponseFB) {
                CoroutineScope(Dispatchers.IO).launch{
                    print(responseFB)
                }
            }
        })
    }

    private fun print(response: ResponseFB) {

        response.products?.let { products ->
            products.forEach{ product ->
                product.name?.let {
                    Log.i(TAG, it)
                }
                product.desc?.let {
                    Log.i(TAG, it)
                }
            }
        }

        response.exception?.let { exception ->
            exception.message?.let {
                Log.e(TAG, "null")
            }
        }
    }
}