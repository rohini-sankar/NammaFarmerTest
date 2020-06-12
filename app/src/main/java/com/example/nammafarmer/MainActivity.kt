package com.example.nammafarmer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nammafarmer.R.layout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(layout.activity_main)

        btnSeeds.setOnClickListener {
            val tmpIntent = Intent(this, ActSeedsLanding::class.java)
            startActivity(tmpIntent)
        }

        btnRental.setOnClickListener {
        }

        btnFMarket.setOnClickListener {
        }

        btnSLocation.setOnClickListener {
        }

    }
}