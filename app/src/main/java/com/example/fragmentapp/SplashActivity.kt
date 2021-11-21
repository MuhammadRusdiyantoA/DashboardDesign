package com.example.fragmentapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        val anim1 = AnimationUtils.loadAnimation(this, R.anim.splash_one)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.splash_two)

        val icon = findViewById<ImageView>(R.id.imageView)
        val title = findViewById<TextView>(R.id.textView4)

        icon.startAnimation(anim1)
        title.startAnimation(anim2)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}