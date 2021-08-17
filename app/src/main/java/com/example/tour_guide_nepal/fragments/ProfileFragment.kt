package com.example.tour_guide_nepal.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.MainActivity
import com.example.tour_guide_nepal.R
import kotlinx.android.synthetic.main.activity_gorkha_weather.*


@Suppress("UNREACHABLE_CODE")
class ProfileFragment : Fragment() {
    private lateinit var profilename: TextView

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

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        val view=inflater.inflate(R.layout.fragment_profile, container, false)
        etfullname=view.findViewById(R.id.etfullname)
        etemail=view.findViewById(R.id.etemail)
        etphone=view.findViewById(R.id.etphone)
        txtfullname=view.findViewById(R.id.txtfullname)
        txtemail=view.findViewById(R.id.txtemail)

        return view

    imageView.setOnClickListener{
        val pictureDialog = AlertDialog.Builder(activity)
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
        backhome.setOnClickListener{
            startActivity(Intent(activity,MainActivity::class.java))
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
    AlertDialog.Builder(activity)
        .setMessage(
            "It looks like you have turned off your permissions"
                    + "required for this feature. It can be enabled under App settings"
        )
        .setPositiveButton("Go to settings") { _, _ ->
            try {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", "packageName", null)
                intent.data = uri
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
        .setNegativeButton("CANCEL") { dialog, _ ->
            dialog.dismiss()
        }.show()


}
}