package com.kelompok4bp.eatsie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSignUp = findViewById<AppCompatButton>(R.id.btnSignUp)
        val txtLogin = findViewById<TextView>(R.id.tvTextLogin)

        btnSignUp.setOnClickListener {
            val moveIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        txtLogin.setOnClickListener {
            val moveIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(moveIntent)
            finish()
        }
    }
}