package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.kategori.Categorise

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val button1: Button = findViewById(R.id.buyButton)

        button1.setOnClickListener {
            val intent = Intent(this@BerandaActivity, Categorise::class.java)
            startActivity(intent)
        }
    }
}