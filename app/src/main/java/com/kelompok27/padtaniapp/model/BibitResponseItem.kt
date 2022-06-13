package com.kelompok27.padtaniapp.model

import com.google.gson.annotations.SerializedName

data class BibitResponseItem(

    @field:SerializedName("umur")
    val umur: String,

    @field:SerializedName("potensi_hasil")
    val potensiHasil: String,

    @field:SerializedName("created_at")
    val createdAt: String,

    @field:SerializedName("gambar")
    val gambar: String,

    @field:SerializedName("penyakit")
    val penyakit: String,

    @field:SerializedName("kategori_id")
    val kategoriId: Int,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("harga")
    val harga: Int,

    @field:SerializedName("updated_at")
    val updatedAt: String,

    @field:SerializedName("anjuran_tanam")
    val anjuranTanam: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("hama")
    val hama: String,

    @field:SerializedName("tekstur")
    val tekstur: String
)
