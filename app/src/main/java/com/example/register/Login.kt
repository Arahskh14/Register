package com.example.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val registerButton = findViewById<AppCompatButton>(R.id.btn1)
        registerButton.setOnClickListener {
            // Add code here to navigate to the next feature or activity
            // For example, you can start a new activity:
            val intent = Intent(this@Login, Register::class.java)

            startActivity(intent);
        }
    }
}