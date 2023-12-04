package com.example.register.booking

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import com.example.register.R

class Kalender : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalender)

        val date = findViewById<DatePicker>(R.id.datepick) as DatePicker
        val calendar: Calendar = Calendar.getInstance()

        date.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ) { _, year, monthOfYear, dayOfMonth ->
            val selectedDate = "$dayOfMonth-${monthOfYear + 1}-$year"
            Toast.makeText(applicationContext, "#$selectedDate#", Toast.LENGTH_SHORT).show()

            // Membuat objek Intent untuk beralih ke Booking
            val intent = Intent(this@Kalender, Booking::class.java)

            // Menjalankan Intent untuk memulai Booking
            startActivity(intent)
        }
    }
}
