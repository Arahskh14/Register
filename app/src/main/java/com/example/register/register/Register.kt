package com.example.register.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.register.R
import com.example.register.newusername.Forgetpassword
import com.example.register.login.Login

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button: Button = findViewById(R.id.buttonn)
        val button1: Button = findViewById(R.id.buttonn1)

        button.setOnClickListener {
            val intent = Intent(this@Register, Forgetpassword::class.java)
            startActivity(intent)
        }
        button1.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
        }
    }
}
