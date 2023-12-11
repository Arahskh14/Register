package com.example.register.newusername

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.register.R

class usernamenew: AppCompatActivity() {

    private lateinit var edittext1: EditText
    private lateinit var edittext2: EditText
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usernamenew)

        // Initialize your views
        edittext1 = findViewById(R.id.edittext1)
        edittext2 = findViewById(R.id.edittext2)
        btn = findViewById(R.id.btn)

        // Set click listener for button
        btn.setOnClickListener {
            // Handle button click
            if (areFieldsValid()) {
                // Check if passwords match
                if (edittext1.text.toString() == edittext2.text.toString()) {
                    // Passwords match, you can proceed with your logic
                    // For now, it just shows a success message
                    showPopup("Passwords match! You can proceed.")
                } else {
                    // Passwords do not match, show an error message
                    showPopup("Passwords do not match. Please check.")
                }
            } else {
                // Show a pop-up message when either field is empty
                showPopup("Please fill in both fields.")
            }
        }
    }

    private fun areFieldsValid(): Boolean {
        // Check if both fields are filled
        return edittext1.text.isNotBlank() && edittext2.text.isNotBlank()
    }

    private fun showPopup(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setPositiveButton("Sudah sukses") { dialog, _ ->
                dialog.dismiss()
            }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}

