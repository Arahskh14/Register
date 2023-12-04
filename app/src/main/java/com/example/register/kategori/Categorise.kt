package com.example.register.kategori

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.register.R

class Categorise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorise)

        val button: Button = findViewById(R.id.button1)

        button.setOnClickListener {
            val intent = Intent(this@Categorise, Kategori1::class.java)
            startActivity(intent)
        }

        // Dalam aktivitas atau fragmen
        val cardView = findViewById<CardView>(R.id.cardview)
        cardView.setOnClickListener {
            // Tangani interaksi klik di sini
            // Buka peta atau lakukan tindakan lain
            val location = "JL. Cikarang,Barat,Bekasi" // Lokasi yang ingin Anda tampilkan di peta
            openMaps(location)
        }
    }

    private fun openMaps(location: String) {
        val gmmIntentUri = Uri.parse("geo:0,0?q=$location")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps") // Pastikan aplikasi Google Maps diinstal
        startActivity(mapIntent)
    }
}
