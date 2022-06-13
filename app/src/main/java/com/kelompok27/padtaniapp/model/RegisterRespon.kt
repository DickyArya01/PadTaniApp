package com.kelompok27.padtaniapp.model

import com.google.gson.annotations.SerializedName

data class RegisterRespon(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)
