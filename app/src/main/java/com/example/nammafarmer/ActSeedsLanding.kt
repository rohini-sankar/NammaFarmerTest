package com.example.nammafarmer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act_seeds_landing.*

class ActSeedsLanding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_seeds_landing)

        //Seeds Buy Button
        btnSeedsBuy.setOnClickListener {
            val tmpIntent = Intent(this, ActSeedsLandingBuy::class.java)
            startActivity(tmpIntent)
        }

        //Seeds Sell Button
        btnSeedsSell.setOnClickListener {
            val tmpIntent = Intent(this, ActSeedsLandingSell::class.java)
            startActivity(tmpIntent)
        }

    }
}
