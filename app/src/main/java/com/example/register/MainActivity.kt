package com.example.register

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image1 = findViewById<ImageView>(R.id.image1)
        image1.setOnClickListener { //  Tambahkan kode untuk menavigasi ke aktivitas selanjutnya di sini
            navigateToNextActivity()
        }
    }

    private fun navigateToNextActivity() {
        // Gunakan Intent untuk menavigasi ke aktivitas selanjutnya
        val intent = Intent(this, Login::class.java)
        // Gantilah NextActivity.class dengan nama aktivitas selanjutnya
        startActivity(intent)
    }
}
