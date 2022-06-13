package com.kelompok27.padtaniapp.api

import com.kelompok27.padtaniapp.model.LoginResponse
import com.kelompok27.padtaniapp.model.RegisterRespon
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiConfig {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterRespon>



}