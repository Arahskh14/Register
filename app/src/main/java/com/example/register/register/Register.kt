package com.example.register.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.register.R
import com.example.register.login.Notifikasilogin

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button: Button = findViewById(R.id.buttonn)

        button.setOnClickListener {
            // Memeriksa apakah semua kotak isian telah diisi dengan benar
            if (isValidInput()) {
                // Jika validasi berhasil, lanjutkan ke halaman notifikasi login
                val intent = Intent(this@Register, Notifikasilogin::class.java)
                startActivity(intent)
            }
        }
    }

    // Metode untuk memeriksa apakah semua kotak isian telah diisi
    private fun isValidInput(): Boolean {
        // Dapatkan referensi ke EditText
        val editTextEmail = findViewById<EditText>(R.id.edittext)
        val editTextPassword = findViewById<EditText>(R.id.edittext1)
        val editTextConfirmPassword = findViewById<EditText>(R.id.edittext2)

        // Ambil nilai dari kotak isian
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        val confirmPassword = editTextConfirmPassword.text.toString().trim()

        // Memeriksa apakah email, password, dan konfirmasi password tidak kosong
        if (email.isEmpty()) {
            editTextEmail.error = "Email harus diisi!"
            return false
        }
        if (password.isEmpty()) {
            editTextPassword.error = "Password harus diisi!"
            return false
        }
        if (confirmPassword.isEmpty()) {
            editTextConfirmPassword.error = "Confirm Password!"
            return false
        }
        // Memeriksa apakah password dan konfirmasi password sesuai
        if (password != confirmPassword) {
            editTextConfirmPassword.error = "Password tidak sesuai!"
            return false
        }
        // Jika semua kotak isian diisi, kembalikan nilai true
        return true
    }
}

