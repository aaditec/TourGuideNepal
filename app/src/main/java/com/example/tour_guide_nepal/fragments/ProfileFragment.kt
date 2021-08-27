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
import androidx.appcompat.app.AppCompatActivity
 
import coil.load
import coil.transform.CircleCropTransformation
 
 
import androidx.core.content.ContextCompat.startActivity
 

import com.example.tour_guide_nepal.ENTITY.User
 
import coil.transform.CircleCropTransformation
 
import com.example.tour_guide_nepal.LoginActivity
import com.example.tour_guide_nepal.MainActivity
import com.example.tour_guide_nepal.R

import kotlinx.android.synthetic.main.activity_gorkha_weather.*
 
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
 
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

        }}

 






  
