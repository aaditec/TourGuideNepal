package com.example.tour_guide_nepal.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
 
import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.LoginActivity
import com.example.tour_guide_nepal.MainActivity
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.Repository.UserRepository
import kotlinx.android.synthetic.main.activity_gorkha_weather.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
  
import com.example.tour_guide_nepal.LoginActivity
import com.example.tour_guide_nepal.MainActivity
import com.example.tour_guide_nepal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream
 


@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class ProfileFragment : Fragment() {

        companion object {
            const val REQUEST_CAMERA = 100
        }

        private lateinit var db: FirebaseFirestore
        private lateinit var imageUri: Uri


        private lateinit var backhome: FrameLayout
        private lateinit var imageView: ImageView
        private lateinit var camera: ImageView

        private lateinit var etfullname: TextView
        private lateinit var eefullname: TextView
        private lateinit var eeemail: TextView
        private lateinit var etemail: TextView
        private lateinit var etphone: TextView

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        etfullname = view.findViewById(R.id.etfullname)
        etemail = view.findViewById(R.id.etemail)
        etphone = view.findViewById(R.id.etphone)
        txtfullname = view.findViewById(R.id.txtfullname)
        txtemail = view.findViewById(R.id.txtemail)
        imageView = view.findViewById(R.id.imageView)
        backhome = view.findViewById(R.id.backhome)

 

        imageView.setOnClickListener {
            popupmenu()

        }
        backhome.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }

        val sharedPref =
            requireActivity().getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        val semail = sharedPref.getString("username", "")

        txtemail.setText(semail)
        etemail.setText(semail)
        

        return view
    }

    private fun popupmenu() {
        val pictureDialog = AlertDialog.Builder(activity)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItem = arrayOf("Select photo from Gallery", "Capture photo from Camera")
        pictureDialog.setItems(pictureDialogItem) { dialog, which ->

            when (which) {
                0 -> gallery()
                1 -> camera()
            }
        }
        pictureDialog.show()
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

    private fun gallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
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
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {

                CAMERA_REQUEST_CODE -> {
                    val bitmap = data?.extras?.get("data") as Bitmap

                    //using coroutine image loader (coil)
                    imageView.load(bitmap) {
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                    }
                }

                GALLERY_REQUEST_CODE -> {

                    imageView.load(data?.data) {
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
 

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        @SuppressLint("SetTextI18n")
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment


            val view = inflater.inflate(R.layout.fragment_profile, container, false)
            etfullname = view.findViewById(R.id.ffullname)
            eefullname = view.findViewById(R.id.ettvfullname)
            eeemail = view.findViewById(R.id.ettvemail)
            etemail = view.findViewById(R.id.eemail)
            etphone = view.findViewById(R.id.pphone)
            backhome = view.findViewById(R.id.backhome)
            camera = view.findViewById(R.id.camera)


            val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
            val isLogin = sharedPref.getString("Email", "1")

            if (isLogin == "1") {
                var email = requireActivity().intent.getStringExtra("email")
                if (email != null) {
                    setText(email)
                    with(sharedPref.edit())
                    {
                        putString("Email", email)
                        apply()
                    }
                } else {
                    var intent = Intent(activity, LoginActivity::class.java)
                    startActivity(intent)

                }
            } else {
                setText(isLogin)
            }

            backhome.setOnClickListener {
                startActivity(Intent(activity, MainActivity::class.java))
            }

            camera.setOnClickListener {

                intentcamera()
            }

            return view
        }

        private fun intentcamera() {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
                activity?.packageManager?.let {
                    intent.resolveActivity(it).also {
                        startActivityForResult(intent, REQUEST_CAMERA)
                    }
                }
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
                val imageBitmap = data?.extras?.get("data") as Bitmap
                uploadimage(imageBitmap)
            }
        }

        private fun uploadimage(imageBitmap: Bitmap) {
            val baos = ByteArrayOutputStream()

            val ref =
                FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val image = baos.toByteArray()
            ref.putBytes(image)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        ref.downloadUrl.addOnCompleteListener {
                            it.result?.let {
                                imageUri = it
                                camera.setImageBitmap(imageBitmap)
                            }
                        }
 
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
 


        private fun setText(email: String?) {
            db = FirebaseFirestore.getInstance()
            if (email != null) {
                db.collection("USERS").document(email).get()
                    .addOnSuccessListener { tasks ->
                        ffullname.text = tasks.get("Name").toString()
                        ettvfullname.text = tasks.get("Name").toString()
                        ettvemail.text = tasks.get("email").toString()
                        pphone.text = tasks.get("Phone").toString()
                        eemail.text = tasks.get("email").toString()

                    }
            }

        }
    }






  
