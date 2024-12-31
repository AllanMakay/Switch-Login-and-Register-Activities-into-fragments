package com.mobileapps.lesson2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment(private val credentialsManager: CredentialsManager) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val nextButton = view.findViewById<Button>(R.id.nextButton)
        val registerNowTextView = view.findViewById<TextView>(R.id.registerNowTextView)

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            if (!credentialsManager.isEmailValid(email)) {
                emailEditText.error = "Invalid email address"
                return@setOnClickListener
            }

            // Check if password is valid
            if (!credentialsManager.isPasswordValid(password)) {
                passwordEditText.error = "Password cannot be empty"
                return@setOnClickListener
            }

            Toast.makeText(context, "Logged in successfully!", Toast.LENGTH_SHORT).show()
        }

        registerNowTextView.setOnClickListener {
            (activity as MainActivity).showRegisterFragment()
        }

        return view
    }
}
