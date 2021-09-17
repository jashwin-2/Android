package com.example.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSecondActivity.setOnClickListener {
            val name = etName.text.toString()
            val mobileNo = etMobNo.text.toString().toLong()
            val department = etDepartment.text.toString()
            val person = Person(name,mobileNo,department)
            Intent(this,SecondActivity :: class.java).also {
//                it.putExtra("EXTRA_NAME",name)
//                it.putExtra("EXTRA_MOBILE_NUMBER",mobileNo)
//                it.putExtra("EXTRA_DEPARTMENT",department)
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }
        }
    }

}