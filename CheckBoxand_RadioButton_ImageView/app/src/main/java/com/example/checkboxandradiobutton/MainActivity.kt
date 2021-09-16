package com.example.checkboxandradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btOrder.setOnClickListener{
            val checkRadioButton = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkRadioButton)
            val cheese = cbCheese.isChecked
            val onion = cbOnion.isChecked
            val salad = cbSalad.isChecked
            val orderString = "You Ordered a burger with "+
                    "${meat.text}"+
                    (if(cheese) "\nCheese" else "")+
                    (if(onion) "\nOnion" else "")+
                    (if(salad) "\nSalad" else "")
            tvOrder.text = orderString
        }
    }
}