package com.example.pharmeasy_clone.view

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmeasy_clone.R
import com.example.pharmeasy_clone.view.Login.Login
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var animation1 = AnimationUtils.loadAnimation(applicationContext, R.anim.logo)
        var animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.logo)
        var animation3 = AnimationUtils.loadAnimation(applicationContext, R.anim.logo)
        var animation4 = AnimationUtils.loadAnimation(applicationContext, R.anim.logo)

        imageView.animation = animation1
        imageView2.animation = animation2
        imageView3.animation = animation3
        imageView4.animation = animation4

        GlobalScope.launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, Login::class.java)
            startActivity(intent);
            finish();
        }
    }
}
