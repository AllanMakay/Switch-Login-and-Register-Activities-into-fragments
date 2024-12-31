package com.mobileapps.lesson2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class RegisterFragment(private val credentialsManager: CredentialsManager) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val fullNameEditText = view.findViewById<EditText>(R.id.fullNameEditText)
        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        val phoneNumberEditText = view.findViewById<EditText>(R.id.phoneNumberEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val confirmPasswordEditText = view.findViewById<EditText>(R.id.confirmPasswordEditText)
        val termsCheckBox = view.findViewById<CheckBox>(R.id.termsCheckBox)
        val nextButton = view.findViewById<Button>(R.id.nextButton)
        val loginTextView = view.findViewById<TextView>(R.id.loginTextView)

        nextButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phoneNumber = phoneNumberEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            when {
                fullName.isEmpty() -> showToast("Please enter your full name")
                email.isEmpty() -> showToast("Please enter your email")
                phoneNumber.isEmpty() -> showToast("Please enter your phone number")
                password.isEmpty() -> showToast("Please enter a password")
                confirmPassword.isEmpty() -> showToast("Please confirm your password")
                password != confirmPassword -> showToast("Passwords do not match")
                !termsCheckBox.isChecked -> showToast("Please agree to the terms and conditions")
                else -> {
                    showToast("Registration successful!")
                    (activity as MainActivity).showLoginFragment()
                }
            }
        }

        loginTextView.setOnClickListener {
            (activity as MainActivity).showLoginFragment()
        }

        return view
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
