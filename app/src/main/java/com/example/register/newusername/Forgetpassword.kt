package com.example.register.newusername

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.R

class Forgetpassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpassword)

        val button: Button = findViewById(R.id.buttonnn)

        button.setOnClickListener {
            val intent = Intent(this@Forgetpassword, Notificasionriset::class.java)
            startActivity(intent)
        }
    }
}