package com.example.tour_guide_nepal.vehicle

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tour_guide_nepal.ENTITY.VehicleRentEntity
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.VehicleRentRepository
import com.example.tour_guide_nepal.view.ui.DetailsActivity
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class updatevehiclebooking_activity : AppCompatActivity() {
    private var title = arrayOf("Mr.","Miss")
    private var type_of_vehicle = arrayOf("Two Wheel","Four Wheel")


    private lateinit var spinner1: Spinner
    private lateinit var hirename : EditText
    private lateinit var hireemail : EditText
    private lateinit var hirembnumber : EditText
    private lateinit var hirenoofperson : EditText
    private lateinit var spinner2 : Spinner
    private lateinit var spinner3 : Spinner
    private lateinit var hirestartdate : TextView
    private lateinit var hireenddate : TextView
    private lateinit var hirecomments : EditText
    private lateinit var btnupdate : Button
    private lateinit var btnvrent : Button
    private lateinit var  no_of_vehicle : ScrollableNumberPicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_booking_form)

        spinner1 = findViewById(R.id.spinner1)
        hirename = findViewById(R.id.hirename)
        hireemail = findViewById(R.id.hireemail)
        hirembnumber = findViewById(R.id.hirembnumber)
        hirenoofperson = findViewById(R.id.hirenoofperson)
        spinner2 = findViewById(R.id.spinner2)
        hirestartdate = findViewById(R.id.hirestartdate)
        hireenddate = findViewById(R.id.hireenddate)
        hirecomments = findViewById(R.id.hirecomments)
        btnvrent = findViewById(R.id.btnvrent)
        btnupdate= findViewById(R.id.btnupdate)
        no_of_vehicle = findViewById(R.id.no_of_vehicle)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,title)
        spinner1.adapter = adapter

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,type_of_vehicle)
        spinner2.adapter = adapter1

        //calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //click date to show datepickerdialogue
        hirestartdate.setOnClickListener {
            val dpd =
                DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                        //set to textview
                        hirestartdate.setText("" + mDay + "/" + mMonth + "/" + mYear)
                    },
                    year,
                    month,
                    day
                )

            //show dialog
            dpd.show()

        }
        //click date to show datepickerdialogue
        hireenddate.setOnClickListener {
            val dpd =
                DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                        //set to textview
                        hireenddate.setText("" + mDay + "/" + mMonth + "/" + mYear)
                    },
                    year,
                    month,
                    day
                )
            //show dialog
            dpd.show()

        }
        btnvrent.setOnClickListener {
            rentvehicle()
        }

        val intent = intent.getParcelableExtra<VehicleRentEntity>("Rent_Vehicle_Details")
        if (intent !=null){
            hirename.setText(intent.fullname)
            hireemail.setText(intent.email)
            hirembnumber.setText(intent.phone)
            hirenoofperson.setText(intent.numberofpeople)
            hirestartdate.setText(intent.tripstartdate)
            hireenddate.setText(intent.tripenddate)
            hirecomments.setText(intent.traveldetail)


        }


        btnupdate.setOnClickListener {
            updatevehicle()
        }
    }

    private fun updatevehicle() {
        val intent = intent.getParcelableExtra<VehicleRentEntity>("Rent_Vehicle_Details")
        val title = spinner1.selectedItem.toString()
        val fullname = hirename.text.toString()
        val email = hireemail.text.toString()
        val phone = hirembnumber.text.toString()
        val numberofpeople = hirenoofperson.text.toString()
        val vehicletype = spinner2.selectedItem.toString()
        val numberofvehicle = no_of_vehicle.toString()
        val tripstartdate = hirestartdate.text.toString()
        val tripenddate = hireenddate.text.toString()
        val traveldetail = hirecomments.text.toString()

        val vehicleRentEntity = VehicleRentEntity(
            title= title,
            fullname= fullname,
            email= email,
            phone= phone,
            numberofpeople= numberofpeople,
            vehicletype= vehicletype,
            numberofvehicle= numberofvehicle,
            tripstartdate= tripstartdate,
            tripenddate= tripenddate,
            traveldetail= traveldetail
        )
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val vehicleRentRepository = VehicleRentRepository()
                val response = vehicleRentRepository.updateVehicleRent(intent?._id!!,vehicleRentEntity)
                if (response.message != null){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@updatevehiclebooking_activity, "updated successfully", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (ex:Exception){
                withContext(Dispatchers.Main){
                }
            }
        }
    }

    private fun rentvehicle() {
        val title = spinner1.selectedItem.toString()
        val hirename = hirename.text.toString()
        val hireemail = hireemail.text.toString()
        val hirenumber = hirembnumber.text.toString()
        val noofperson = hirenoofperson.text.toString()
        val vehicletype = spinner2.selectedItem.toString()
        val noofvehicle = no_of_vehicle.toString()
        val hirestartdate = hirestartdate.text.toString()
        val hireenddate = hireenddate.text.toString()
        val hirecomments = hirecomments.text.toString()

        val vehicleRentEntity = VehicleRentEntity(
            title=title,
            fullname= hirename,
            email = hireemail,
            phone = hirenumber,
            numberofpeople = noofperson,
            vehicletype = vehicletype,
            numberofvehicle = noofvehicle,
            tripstartdate = hirestartdate,
            tripenddate = hireenddate,
            traveldetail = hirecomments
        )
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val vehicleRentRepository = VehicleRentRepository()
                val response = vehicleRentRepository.rentvehicle(vehicleRentEntity)

                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@updatevehiclebooking_activity,
                            "Vehicle Rent Successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                        startActivity(Intent(this@updatevehiclebooking_activity, DetailsActivity::class.java))
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@updatevehiclebooking_activity,
                        "Error ${ex.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }
}