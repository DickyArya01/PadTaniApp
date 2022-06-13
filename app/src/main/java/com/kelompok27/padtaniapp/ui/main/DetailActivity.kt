package com.kelompok27.padtaniapp.ui.main

import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.kelompok27.padtaniapp.databinding.ActivityDetailBinding
import com.kelompok27.padtaniapp.helper.Constant
import com.kelompok27.padtaniapp.ml.ColorClassificationQuant
import com.kelompok27.padtaniapp.ml.DiseaseClassificationQuant
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uriPhoto = intent.getStringExtra(Constant.TAGUri)

        val getPhoto = Uri.parse(uriPhoto)

        binding.imgDetailResult.setImageURI(getPhoto)

        val labelNameBwd = "labelBwd.txt"

        val labelNameDisease = "labelDisease.txt"

        val inputStringBwd = application.assets.open(labelNameBwd)
            .bufferedReader().use {
            it.readText()
        }

        val inputStringDisease = application.assets.open(labelNameDisease)
            .bufferedReader().use {
                it.readText()
            }

        var labelListBwd = inputStringBwd.split("\n")

        var labelListDisease = inputStringDisease.split("\n")

        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, getPhoto)

       var maxBwd = getColorBwd()

        var maxDisease = getDiseaseCrop()

       binding.tvTexture.text = labelListBwd[maxBwd]

       binding.tvKondisi.text = labelListDisease[maxDisease]

    }

//    private fun getCropDisease(): Int {
//
//    }
    private fun getDiseaseCrop(): Int {
    var resized: Bitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, true)
    val model = DiseaseClassificationQuant.newInstance(this)

// Creates inputs for reference.
    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 300, 300, 3), DataType.UINT8)

    var tbuffer = TensorImage.fromBitmap(resized)
    var byteBuffer = tbuffer.buffer

    inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer

    var max = getMax(outputFeature0.floatArray)

// Releases model resources if no longer used.
    model.close()

    return max

}

    private fun getColorBwd(): Int {
        var resized: Bitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, true)
        val model = ColorClassificationQuant.newInstance(this)

// Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 300, 300, 3), DataType.UINT8)

        var tbuffer = TensorImage.fromBitmap(resized)
        var byteBuffer = tbuffer.buffer

        inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        var max = getMax(outputFeature0.floatArray)

// Releases model resources if no longer used.
        model.close()

        return max

    }

    fun getMax(arr: FloatArray): Int {
        var index = 0
        var min = 0.0f
        for (i in 0..2) {
            if (arr[i] > min) {
                index = i
                min = arr[i]
            }
        }
        return index
    }

}