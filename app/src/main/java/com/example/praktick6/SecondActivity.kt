package com.example.praktick6

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LOGIN = "extra_login"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        // Получаем логин, переданный с экрана 1 через Intent
        val login = intent.getStringExtra(EXTRA_LOGIN) ?: ""
        tvLogin.text = getString(R.string.welcome_message, login)
    }
}
