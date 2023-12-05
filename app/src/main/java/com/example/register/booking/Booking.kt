package com.example.register.booking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.register.BerandaActivity
import com.example.register.R

class Booking : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val button1: Button = findViewById(R.id.button)

        button1.setOnClickListener {
            val intent = Intent(this@Booking, FormActivity::class.java)
            startActivity(intent)
        }
    }
}
