package com.example.register.newusername

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.R

class usernamenew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usernamenew)

        val button: Button = findViewById(R.id.btn)

        button.setOnClickListener {
            val intent = Intent(this@usernamenew, Notifikasisukses::class.java)
            startActivity(intent)
        }
    }
}