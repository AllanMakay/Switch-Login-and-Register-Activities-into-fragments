package com.mobileapps.lesson2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showLoginFragment()
        }
    }

    fun showLoginFragment() {
        replaceFragment(LoginFragment(credentialsManager))
    }

    fun showRegisterFragment() {
        replaceFragment(RegisterFragment(credentialsManager))
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(null)
            .commit()
    }
}
