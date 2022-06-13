package com.kelompok27.padtaniapp.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("access_tokken")
	val accessTokken: String,

	@field:SerializedName("token_type")
	val tokenType: String
)

data class Data(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("email_verified_at")
	val emailVerifiedAt: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("status")
	val status: String
)
