package com.example.nammafarmer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_act_seeds_landing_sell.*

class ActSeedsLandingSell : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_seeds_landing_sell)

        //var database = FirebaseDatabase.getInstance().reference
        var database = FirebaseDatabase.getInstance().getReference("Seeds")
        //database.setValue("Testing")

/*
        val farmDB = getSharedPreferences("farmDB", Context.MODE_PRIVATE)

        btnSubmit.setOnClickListener {
            if (editTextName.text.toString().trim().isEmpty()) {
                editTextName.error = "Please enter your name..."
                return@setOnClickListener
            }
            if (editTextPhone.text.toString().trim().isEmpty()) {
                editTextPhone.error = "Please enter your phone number..."
                return@setOnClickListener
            }

            farmDB.edit().apply{
                putString("dbName", editTextName.text.toString())
                putString("dbPhone", editTextPhone.text.toString())
                putString("dbEMail", editTextEMail.text.toString())

                if (cBoxSeedsRice.isChecked)
                    putBoolean("dbRice", true)
                else
                    putBoolean("dbRice", false)
                if (cBoxSeedsOnion.isChecked)
                    putBoolean("dbOnion", true)
                else
                    putBoolean("dbOnion", false)
                if (cBoxSeedsTomato.isChecked)
                    putBoolean("dbTomato", true)
                else
                    putBoolean("dbTomato", false)
                if (cBoxSeedsBendi.isChecked)
                    putBoolean("dbBendi", true)
                else
                    putBoolean("dbBendi", false)
                if (cBoxSeedsBrinjal.isChecked)
                    putBoolean("dbBrinjal", true)
                else
                    putBoolean("dbBrinjal", false)
                if (cBoxSeedsPumpkin.isChecked)
                    putBoolean("dbPumpkin", true)
                else
                    putBoolean("dbPumpkin", false)

                if (cBoxSeedsWheat.isChecked)
                    putBoolean("dbWheat", true)
                else
                    putBoolean("dbWheat", false)
                if (cBoxSeedsKarela.isChecked)
                    putBoolean("dbKarela", true)
                else
                    putBoolean("dbKarela", false)
                if (cBoxSeedsBeans.isChecked)
                    putBoolean("dbBeans", true)
                else
                    putBoolean("dbBeans", false)
                if (cBoxSeedsCarrot.isChecked)
                    putBoolean("dbCarrot", true)
                else
                    putBoolean("dbCarrot", false)
                if (cBoxSeedsSquash.isChecked)
                    putBoolean("dbSquash", true)
                else
                    putBoolean("dbSquash", false)
                if (cBoxSeedsRadish.isChecked)
                    putBoolean("dbRadish", true)
                else
                    putBoolean("dbRadish", false)

                if (cBoxSeedsMillets.isChecked)
                    putBoolean("dbMillets", true)
                else
                    putBoolean("dbMillets", false)
                if (cBoxSeedsChilli.isChecked)
                    putBoolean("dbChilli", true)
                else
                    putBoolean("dbChilli", false)
                if (cBoxSeedsGinger.isChecked)
                    putBoolean("dbGinger", true)
                else
                    putBoolean("dbGinger", false)
                if (cBoxSeedsGarlic.isChecked)
                    putBoolean("dbGarlic", true)
                else
                    putBoolean("dbGarlic", false)
                if (cBoxSeedsSpices.isChecked)
                    putBoolean("dbSpices", true)
                else
                    putBoolean("dbSpices", false)
                if (cBoxSeedsOthers.isChecked)
                    putBoolean("dbOthers", true)
                else
                    putBoolean("dbOthers", false)
            }.apply()

            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show()
        }
*/


        btnSubmit.setOnClickListener {

            //Perform validations
            if (editTextName.text.toString().trim().isEmpty()) {
                editTextName.error = "Please enter your name..."
                return@setOnClickListener
            }
            if (editTextPhone.text.toString().trim().isEmpty()) {
                editTextPhone.error = "Please enter your phone number..."
                return@setOnClickListener
            }

            //Get a key for new record
            val farmRecID = database.push().key.toString()

            //Create the new record
            val farmRec = SaveSeeds(
                farmRecID,
                editTextName.text.toString().trim(),
                editTextPhone.text.toString().trim(),
                editTextEMail.text.toString().trim(),
                cBoxSeedsRice.isChecked,
                cBoxSeedsOnion.isChecked,
                cBoxSeedsTomato.isChecked,
                cBoxSeedsBendi.isChecked,
                cBoxSeedsBrinjal.isChecked,
                cBoxSeedsPumpkin.isChecked,
                cBoxSeedsWheat.isChecked,
                cBoxSeedsKarela.isChecked,
                cBoxSeedsBeans.isChecked,
                cBoxSeedsCarrot.isChecked,
                cBoxSeedsSquash.isChecked,
                cBoxSeedsRadish.isChecked,
                cBoxSeedsMillets.isChecked,
                cBoxSeedsChilli.isChecked,
                cBoxSeedsGinger.isChecked,
                cBoxSeedsGarlic.isChecked,
                cBoxSeedsSpices.isChecked,
                cBoxSeedsOthers.isChecked
            )

            if (farmRecID != null) {
                database.child(farmRecID).setValue(farmRec).addOnCompleteListener {
                    Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
