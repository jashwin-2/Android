package com.example.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val name = intent.getStringExtra("EXTRA_NAME")
        val mobileNo = intent.getLongExtra("EXTRA_MOBILE_NUMBER",0)
        val department = intent.getStringExtra("EXTRA_DEPARTMENT")
        val person = intent.getSerializableExtra("EXTRA_PERSON")
      //  textView2.text = "Name $name\nMobile No $mobileNo \nDepartment $department"
        textView2.text = person.toString()
        btnFirstActivity.setOnClickListener(this)
        btnThirdActivity.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
       if (view == btnFirstActivity)
           finish()
        else
            Intent(this,ThirdActivity :: class.java).also {
                startActivity(it)
            }
    }

}