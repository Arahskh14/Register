package com.example.register.newusername

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.R
import com.example.register.login.Login
import com.example.register.register.Register

class Notificasionriset : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificasionriset)

        val button: Button = findViewById(R.id.btn)

        button.setOnClickListener {
            val intent = Intent(this@Notificasionriset, Otp::class.java)
            startActivity(intent)
        }


    }
}