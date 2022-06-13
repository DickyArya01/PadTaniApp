package com.kelompok27.padtaniapp.model

import com.google.gson.annotations.SerializedName

data class BibitRespone (

@field:SerializedName("followers")
val followers: Int,

@field:SerializedName("avatar_url")
val avatarUrl: String,

@field:SerializedName("following_url")
val followingUrl: String,

@field:SerializedName("following")
val following: Int,

@field:SerializedName("name")
val name: String,

@field:SerializedName("id")
val id: Int,

@field:SerializedName("login")
val login: String,

@field:SerializedName("followers_url")
val followersUrl: String,

@field:SerializedName("location")
val location: String?,

@field:SerializedName("repos_url")
val repo: String?,

@field:SerializedName("company")
val company: String?

)

