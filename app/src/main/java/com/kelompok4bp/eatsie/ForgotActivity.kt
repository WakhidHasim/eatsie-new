package com.kelompok4bp.eatsie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val btnBack = findViewById<ImageView>(R.id.ivIconBack)

        btnBack.setOnClickListener {
            val moveIntent = Intent(this@ForgotActivity, LoginActivity::class.java)
            startActivity(moveIntent)
            finish()
        }
    }
}