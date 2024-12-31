package com.mobileapps.lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)


        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val registerNowTextView = findViewById<TextView>(R.id.registerNowTextView)


        val credentialsManager = CredentialsManager()


        nextButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            if (!credentialsManager.isEmailValid(email)) {
                emailEditText.error = "Invalid email address"
                return@setOnClickListener
            }


            if (!credentialsManager.isPasswordValid(password)) {
                passwordEditText.error = "Password cannot be empty"
                return@setOnClickListener
            }

            Toast.makeText(this, "Logged in successfully!", Toast.LENGTH_SHORT).show()
        }


        registerNowTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
