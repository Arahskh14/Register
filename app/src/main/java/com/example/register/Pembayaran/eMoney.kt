package com.example.register.Pembayaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.R

class eMoney : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emoney)

        val button : Button = findViewById(R.id.dompetDigital)
        button.setOnClickListener {
            val intent = Intent(this@eMoney, danaFragment::class.java )
            startActivity(intent)
        }
    }
}