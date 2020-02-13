package com.android.pinview

import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.goodiebag.pinview.Pinview

class MainActivity : AppCompatActivity() {
    private var otpTextView: OtpTextView? = null

    private fun initializeWidgets() {
        val pinview1 = findViewById<Pinview>(R.id.pinview1)
        pinview1.pinLength = 6
        pinview1.setPinViewEventListener { pinview, fromUser ->
            Toast.makeText(
                this@MainActivity,
                pinview.value,
                Toast.LENGTH_SHORT
            ).show()
        }


        // pinView Customize
        val pinview5 = findViewById<Pinview>(R.id.pinview5)
        pinview5.setCursorShape(R.drawable.example_cursor)
        pinview5.setTextSize(18)
        pinview5.setTextColor(Color.BLACK)
        pinview5.showCursor(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeWidgets()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.black)
        }
        //val errorButton = findViewById<Button>(R.id.button)
        //val successButton = findViewById<Button>(R.id.button2)
        otpTextView = findViewById(R.id.otp_view)
        otpTextView?.requestFocusOTP()
        otpTextView?.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                Toast.makeText(applicationContext, otp , Toast.LENGTH_SHORT).show()
            }
        }
        //errorButton.setOnClickListener { otpTextView?.showError() }
        //successButton.setOnClickListener { otpTextView?.showSuccess() }

    }
}
//end
