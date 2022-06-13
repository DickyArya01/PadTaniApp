package com.kelompok27.padtaniapp.ui.main.ui.explore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelompok27.padtaniapp.api.Api
import com.kelompok27.padtaniapp.helper.Constant
import com.kelompok27.padtaniapp.model.BibitResponse
import com.kelompok27.padtaniapp.model.BibitResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreViewModel: ViewModel() {
    val listBibit = MutableLiveData<ArrayList<BibitResponseItem>>()

    fun getBibit() {
        Api.getApi().getBibit().enqueue(object : Callback<BibitResponse>{
            override fun onResponse(call: Call<BibitResponse>, response: Response<BibitResponse>) {
                Log.d(Constant.Okhttp, response.code().toString())
                Log.d(Constant.Okhttp, response.body().toString())
            }

            override fun onFailure(call: Call<BibitResponse>, t: Throwable) {
                Log.d(Constant.Okhttp, t.message.toString())
            }

        })
    }

}