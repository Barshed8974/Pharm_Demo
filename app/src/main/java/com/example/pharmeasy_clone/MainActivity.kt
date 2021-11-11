package com.example.pharmeasy_clone


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.pharmeasy_clone.Fragments.AccountFragment
import com.example.pharmeasy_clone.Fragments.HealthCareFragment
import com.example.pharmeasy_clone.Fragments.HomeFragment
import com.example.pharmeasy_clone.Fragments.LabTestsFragment
import com.example.pharmeasy_clone.Fragments.NotificationsFragmnet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                3 -> fragment = NotificationsFragmnet()
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
}