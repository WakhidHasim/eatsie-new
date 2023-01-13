package com.kelompok4bp.eatsie.response.login

data class LoginResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
)