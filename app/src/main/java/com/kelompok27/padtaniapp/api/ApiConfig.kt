package com.kelompok27.padtaniapp.api

import com.kelompok27.padtaniapp.model.BibitResponse
import com.kelompok27.padtaniapp.model.LoginResponse
import retrofit2.http.*

interface ApiConfig {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): retrofit2.Call<LoginResponse>

//    @FormUrlEncoded
//    @POST("register")
//    fun register(
//        @Field("nama") name: String,
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): Call<RegisterRespon>

    @GET("padi")
    fun getBibit(
    ): retrofit2.Call<BibitResponse>



}