package com.kelompok4bp.eatsie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val txtRegister = findViewById<TextView>(R.id.tvTextRegister)

        txtForgotPassword.setOnClickListener {
            val moveIntent = Intent(this@LoginActivity, ForgotActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        btnLogin.setOnClickListener {
            val moveIntent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        txtRegister.setOnClickListener {
            val moveIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(moveIntent)
            finish()
        }
    }
}