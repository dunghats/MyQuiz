package com.example.app_quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_quizz.R
import android.content.Intent
import android.os.Handler
import com.example.app_quizz.MainActivity

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        Handler().postDelayed({
            val i = Intent(this@HelloActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}