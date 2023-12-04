package com.example.register.kategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.R

class Kategori1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori1)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this@Kategori1, Categorise::class.java)
            startActivity(intent)
        }
    }
}