package com.example.register.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.register.R
import com.example.register.home.HomeFragment
import com.example.register.newusername.Forgetpassword
import com.example.register.register.Register

class Login : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var forgotPasswordText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.edittext)
        passwordEditText = findViewById(R.id.edittext1)
        loginButton = findViewById(R.id.buttonlogin)
        registerButton = findViewById(R.id.button1)
        forgotPasswordText = findViewById(R.id.text3)

        loginButton.setOnClickListener {
            loginUser()
        }

        registerButton.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }

        forgotPasswordText.setOnClickListener {
            val intent = Intent(this@Login, Forgetpassword::class.java)
            startActivity(intent)
        }
    }
    private fun loginUser() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            // Use FragmentManager to replace the current fragment with HomeFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        } else {
            if (email.isEmpty()) {
                emailEditText.error = "Email harus diisi!!"
            }
            if (password.isEmpty()) {
                passwordEditText.error = "Password harus diisi!!"
            }
        }
    }


    fun onImageClick(view: View) {
        when (view.id) {
            R.id.image3 -> openGmail()
            R.id.image4 -> openFacebook()
        }
    }

    private fun openGmail() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://accounts.google.com/signup")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No browser found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openFacebook() {
        val facebookUsername = "USERNAME"
        val facebookAppIntent = packageManager.getLaunchIntentForPackage("com.facebook.katana")

        if (facebookAppIntent != null) {
            // Aplikasi Facebook terpasang, buka profil pengguna langsung
            val uri = Uri.parse("fb://profile/$facebookUsername")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        } else {
            // Aplikasi Facebook tidak terpasang, buka browser dengan halaman Facebook
            val uri = Uri.parse("https://www.facebook.com/$facebookUsername")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

}
