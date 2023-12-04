package com.example.register.kategori

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.register.R

class Categorise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kategori)

        val button: Button = findViewById(R.id.button1)

        button.setOnClickListener {
            val intent = Intent(this@Categorise, Kategori1::class.java)
            startActivity(intent)
        }
    }
}