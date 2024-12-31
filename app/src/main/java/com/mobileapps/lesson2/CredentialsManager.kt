package com.mobileapps.lesson2

class CredentialsManager {

    fun isEmailValid(email: String?): Boolean {
        if (email.isNullOrBlank()) return false
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return emailRegex.matches(email)
    }

    fun isPasswordValid(password: String?): Boolean {
        return !password.isNullOrBlank()
    }
}
