package com.example.tour_guide_nepal

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.checkSelfPermission
import androidx.core.app.ActivityCompat.startActivityForResult
import coil.load
import coil.transform.CircleCropTransformation
import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.databinding.ActivityMainBinding
import com.example.tour_guide_nepal.fragments.Select_cityFragment
import com.example.tour_guide_nepal.fragments.Selectplaces
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.karumi.dexter.Dexter
import com.karumi.dexter.DexterBuilder
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import org.jetbrains.anko._Gallery
import org.jetbrains.anko.startActivityForResult

class Profile_Activity : AppCompatActivity() {
    private lateinit var backhome: FrameLayout
    private lateinit var imageView: ImageView
    private val CAMERA_REQUEST_CODE = 1
    private val GALLERY_REQUEST_CODE = 2
    private lateinit var etfullname: TextView
    private lateinit var etemail: TextView
    private lateinit var etphone: TextView
    private lateinit var txtfullname: TextView
    private lateinit var txtemail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        etfullname = findViewById(R.id.etfullname)
        etemail = findViewById(R.id.etemail)
        etphone = findViewById(R.id.etphone)
        txtfullname = findViewById(R.id.txtfullname)
        txtemail = findViewById(R.id.txtemail)


        backhome=findViewById(R.id.backhome)
        imageView=findViewById(R.id.imageView)




        backhome.setOnClickListener{
                startActivity(Intent(this,MainActivity::class.java))
        }

        val user = User()


        imageView.setOnClickListener{
        val pictureDialog = AlertDialog.Builder(this)
            pictureDialog.setTitle("Select Action")
            val pictureDialogItem= arrayOf("Select photo from Gallery","Capture photo from Camera")
                pictureDialog.setItems(pictureDialogItem){ dialog, which ->

                    when(which){
                        0-> gallery()
                        1-> camera()
                    }
                }
            pictureDialog.show()

        }

    }

//    private fun galleryCheckPermission() {
//        Dexter.withContext(this).withPermission(
//                 android.Manifest.permission.READ_EXTERNAL_STORAGE
//        ).withListener(object: PermissionListener{
//            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
//                gallery()
//            }
//
//            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
//                Toast.makeText(
//                    this@Profile_Activity,
//                    "You have denied the storage permission to select image",
//                    Toast.LENGTH_SHORT
//                ).show()
//                showRotationalDialogForPermission()
//            }
//
//            override fun onPermissionRationaleShouldBeShown(
//                p0: PermissionRequest?,
//                p1: PermissionToken?
//            ) {
//                showRotationalDialogForPermission()
//            }
//        }).onSameThread().check()
//    }

    private fun gallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type= "image/*"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

//    private fun cameraCheckPermission() {
//        Dexter.withContext(this)
//            .withPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
//            .withListener(
//                object: MultiplePermissionsListener{
//                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
//                       report?.let{
//                           if (report.areAllPermissionsGranted()){
//                               camera()
//                           }
//                       }
//                    }
//
//                    override fun onPermissionRationaleShouldBeShown(
//                        p0: MutableList<PermissionRequest>?,
//                        p1: PermissionToken?
//                    ) {
//                        showRotationalDialogForPermission()
//                    }
//
//                }
//            ).onSameThread().check()
//    }


    private fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            when (requestCode){

                CAMERA_REQUEST_CODE ->{
                    val bitmap= data?.extras?.get("data") as Bitmap

                    //using coroutine image loader (coil)
                        imageView.load(bitmap){
                            crossfade(true)
                            crossfade(1000)
                            transformations(CircleCropTransformation() )
                        }
                }

                GALLERY_REQUEST_CODE ->{

                    imageView.load(data?.data){
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                    }
                }

            }
        }
    }


    private fun showRotationalDialogForPermission() {
       AlertDialog.Builder(this)
           .setMessage("It looks like you have turned off your permissions"
                   +"required for this feature. It can be enabled under App settings")
           .setPositiveButton("Go to settings"){_,_ ->
               try {
                   val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                   val uri= Uri.fromParts("package", packageName, null)
                   intent.data = uri
                   startActivity(intent)
               }
               catch (e: ActivityNotFoundException){
                        e.printStackTrace()
               }
           }
           .setNegativeButton("CANCEL"){dialog,_ ->
               dialog.dismiss()
           }.show()
    }
}