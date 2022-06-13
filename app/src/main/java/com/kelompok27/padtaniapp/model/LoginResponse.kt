package com.kelompok27.padtaniapp.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

@field:SerializedName("loginResult")
val loginResult: LoginResult,

@field:SerializedName("error")
val error: Boolean,

@field:SerializedName("message")
val message: String
)

data class LoginResult(

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,

)
