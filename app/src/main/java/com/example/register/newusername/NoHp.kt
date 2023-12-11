package com.example.register.newusername

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.register.R

class NoHp : AppCompatActivity() {

    private val SMS_PERMISSION_REQUEST_CODE = 1
    private val NOTIFICATION_CHANNEL_ID = "OTP_NOTIFICATION_CHANNEL"
    private val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_hp)

        // Check if notification channel needs to be created
        createNotificationChannel()

        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)
        val editTextPhoneNumber: EditText = findViewById(R.id.editTextPhoneNumber)

        buttonSubmit.setOnClickListener {
            val phoneNumber = editTextPhoneNumber.text.toString()

            if (phoneNumber.isNotEmpty()) {
                // Check SMS permission (SEND_SMS) for Android 6.0 and above
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.SEND_SMS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.SEND_SMS),
                        SMS_PERMISSION_REQUEST_CODE
                    )
                } else {
                    sendOtp(phoneNumber)
                }
            } else {
                Toast.makeText(this, "Masukkan nomor HP terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun sendOtp(phoneNumber: String) {
        val otp = generateOtp()

        // Get Subscription ID (if needed)
        val subId = SmsManager.getDefaultSmsSubscriptionId()
        val smsManagerForSubscription = SmsManager.getSmsManagerForSubscriptionId(subId)

        // Send SMS
        smsManagerForSubscription.sendTextMessage(phoneNumber, null, "Your OTP is: $otp", null, null)

        // Display OTP to the user
        showOtpToUser(phoneNumber, otp)

        // Display notification for the OTP
        showNotification("Your OTP is: $otp")
    }

    private fun showOtpToUser(phoneNumber: String, otp: String) {
        Toast.makeText(this, "OTP: $otp", Toast.LENGTH_SHORT).show()

        // Call the com.example.register.newusername.Otp activity and send OTP and phone number via Intent
        val intent = Intent(this, Otp::class.java)
        intent.putExtra(Otp.EXTRA_PHONE_NUMBER, phoneNumber)
        intent.putExtra(Otp.EXTRA_OTP, otp)
        startActivity(intent)
        finish()
    }

    private fun generateOtp(): String {
        // Generate a random 4-digit OTP
        val otp = (1000..9999).random()

        // Format the OTP as a 4-digit string (e.g., 0123, 4567)
        return String.format("%04d", otp)
    }


    // Handle the result of the permission request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == SMS_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, send OTP
                val phoneNumber =
                    findViewById<EditText>(R.id.editTextPhoneNumber).text.toString()
                sendOtp(phoneNumber)
            } else {
                // Permission denied, handle accordingly (e.g., show a message to the user)
                Toast.makeText(this, "Izin SMS dibutuhkan untuk mengirim OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Create a notification channel for Android 8.0 and above
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "OTP Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Show a notification with the given message
    private fun showNotification(message: String) {
        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("OTP Notification")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}
