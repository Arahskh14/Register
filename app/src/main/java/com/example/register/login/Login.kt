package com.example.register.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.register.R
import com.example.register.kategori.Categorise
import com.example.register.register.Register


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button: Button = findViewById(R.id.buttonlogin)
        val button1: Button = findViewById(R.id.button1)

        button.setOnClickListener {
            val intent = Intent(this@Login, Categorise::class.java)
            startActivity(intent)
        }

        button1.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }
    }
}
