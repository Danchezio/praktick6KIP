package com.example.praktick6
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etLogin    = findViewById<EditText>(R.id.etLogin)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirm  = findViewById<EditText>(R.id.etConfirm)
        val btnCalc    = findViewById<Button>(R.id.btnCalculate)
        val btnNext    = findViewById<Button>(R.id.btnNext)
        btnCalc.setOnClickListener {
            val error = validate(etLogin, etPassword, etConfirm)
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.toast_validation_ok, Toast.LENGTH_SHORT).show()
            }
        }
        btnCalc.setOnLongClickListener {
            etLogin.text.clear()
            etPassword.text.clear()
            etConfirm.text.clear()
            Toast.makeText(this, R.string.toast_fields_cleared, Toast.LENGTH_SHORT).show()
            true
        }
        btnNext.setOnClickListener {
            val error = validate(etLogin, etPassword, etConfirm)
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(SecondActivity.EXTRA_LOGIN, etLogin.text.toString())
                startActivity(intent)
            }
        }
    }
    private fun validate(login: EditText, password: EditText, confirm: EditText): String? {
        if (login.text.isNullOrEmpty()) return getString(R.string.error_empty_login)
        if (password.text.length < 6)   return getString(R.string.error_short_password)
        if (password.text.toString() != confirm.text.toString())
            return getString(R.string.error_password_mismatch)
        return null
    }
}