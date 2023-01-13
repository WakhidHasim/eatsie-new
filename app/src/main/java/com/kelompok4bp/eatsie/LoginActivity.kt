package com.kelompok4bp.eatsie

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.kelompok4bp.eatsie.api.BaseRetrofit
import com.kelompok4bp.eatsie.response.login.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private val api by lazy { BaseRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val txtRegister = findViewById<TextView>(R.id.tvTextRegister)
        val txtEmail = findViewById<EditText>(R.id.etEmail)
        val txtPassword = findViewById<EditText>(R.id.etPassword)

        txtForgotPassword.setOnClickListener {
            val moveIntent = Intent(this@LoginActivity, ForgotActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        btnLogin.setOnClickListener {
            api.login(txtEmail.text.toString(), txtPassword.text.toString()).enqueue(object :
                Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    Log.e("LoginData",response.toString())
                    val correct = response.body()!!.success

                    if (correct) {
                        sessionManager.saveBoolean("LOGIN_STATUS", true)
                        sessionManager.saveString("ADMIN_ID", response.body()!!.data.user.id_user.toString())

                        val moveIntent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(moveIntent)
                        finish()
                    } else {
                        Toast.makeText(applicationContext, "Email dan Password Salah", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("LoginError",t.toString())
                }

            })
        }

        txtRegister.setOnClickListener {
            val moveIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(moveIntent)
            finish()
        }
    }
}