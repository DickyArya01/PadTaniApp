package com.kelompok27.padtaniapp.model

import com.google.gson.annotations.SerializedName

data class BibitResponse(

	@field:SerializedName("BibitResponse")
	val bibitResponse: ArrayList<BibitResponseItem>
)

