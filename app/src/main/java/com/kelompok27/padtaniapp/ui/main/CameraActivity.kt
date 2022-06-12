package com.kelompok27.padtaniapp.ui.main

import android.R.attr.data
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.ActivityCameraBinding
import com.kelompok27.padtaniapp.helper.Constant
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*


class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding

    private var imageCapture: ImageCapture? = null
    private lateinit var outputDirectory: File

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        outputDirectory = getOutputDirectory()

        if(allPermissionGranted()) {
            startCamera()
        }else{
            ActivityCompat.requestPermissions( this, Constant.REQUIRED_PERMISSION,
                Constant.REQUEST_CODE_PERMISSION )
        }

        binding.btnClose.setOnClickListener {
            Intent(this@CameraActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }


        binding.btnCapture.setOnClickListener { takePhoto() }

        binding.btnFolder.setOnClickListener { openGallery() }

        binding.btnClose.setOnClickListener { closeCameraActivity() }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == Constant.REQUEST_CODE_PERMISSION) {
            if(allPermissionGranted()) {
                startCamera()
            } else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
                finish()

            }
        }
    }

    private fun allPermissionGranted() =
        Constant.REQUIRED_PERMISSION.all{
            ContextCompat.checkSelfPermission(
                baseContext, it
            ) == PackageManager.PERMISSION_GRANTED
        }

    private fun closeCameraActivity() {
        Intent(this@CameraActivity, MainActivity::class.java).also {
            startActivity(it)
        }
    }

    public override fun onResume() {
        super.onResume()
        hideSystemUI()
        startCamera()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider
            .getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also { mPreview ->
                    mPreview.setSurfaceProvider(
                        binding.cameraFinder.surfaceProvider
                    )
                }

            imageCapture = ImageCapture.Builder()
                .build()

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
               cameraProvider.unbindAll()
               cameraProvider.bindToLifecycle(
                   this, cameraSelector, preview, imageCapture
               )
            }catch (e: Exception) {
                Log.d(Constant.TAG, "start camerax failed", e)
            }
        }, ContextCompat.getMainExecutor(this))
    }

    private fun getOutputDirectory(): File{
        val mediaDir = externalMediaDirs.firstOrNull().let { mFile ->
            File(mFile, resources.getString(R.string.app_name)).apply {
                mkdirs()
            }
        }
        return if (mediaDir.exists())
            mediaDir else filesDir
    }

    private fun takePhoto() {
        val imageCapture = imageCapture ?: return
        val photoFile = File (
            outputDirectory,
            SimpleDateFormat(Constant.FILE_NAME_FORMAT, Locale.getDefault())
                .format(System.currentTimeMillis()) + ".jpg"
        )
        val outputOption = ImageCapture.OutputFileOptions
            .Builder(photoFile)
            .build()

        imageCapture.takePicture(
            outputOption, ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback{
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    val msg = "Photo Saved"
                    Toast.makeText(this@CameraActivity, "$msg $savedUri", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@CameraActivity, DetailActivity::class.java)
                    intent.putExtra(Constant.TAGUri, savedUri.toString())
                    startActivity(intent)
                    finish()

                }
                override fun onError(exception: ImageCaptureException) {
                    Log.d(Constant.TAG,"onError: ${exception.message}",
                    exception)
                }

            }
        )
    }

    private fun openGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode == RESULT_OK){
            val selectedImg: Uri = it.data?.data as Uri
            val intent = Intent(this@CameraActivity, DetailActivity::class.java)
            intent.putExtra(Constant.TAGUri, selectedImg.toString())
            startActivity(intent)
        } else {
            Log.d("gallery", "error ")
        }
    }


    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }


}