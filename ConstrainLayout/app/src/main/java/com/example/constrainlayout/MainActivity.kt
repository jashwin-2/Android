package com.example.constrainlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnApply.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val country = etCountry.text.toString()
            val dateOfBirth = etDateOfBirth.text.toString()
            Log.d("MainActivity","$firstName $lastName born on $dateOfBirth from $country just applied")
            tvResult.text ="$firstName $lastName born on $dateOfBirth from $country just applied"
            tvResult.visibility = View.VISIBLE
        }
    }
}