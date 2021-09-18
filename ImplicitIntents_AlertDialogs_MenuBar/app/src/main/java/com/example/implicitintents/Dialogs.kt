package com.example.implicitintents

import android.app.AlertDialog
import android.widget.Toast


class Dialogs(private val context : MainActivity) {


    private val options = arrayOf("First Item","Second Item","Third Item")
    val multiChoiceDialog: AlertDialog = AlertDialog.Builder(context)
        .setTitle("Choose on of the options")
        .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ _, i, isChecked ->
            if(isChecked)
                Toast.makeText(context,"You checked  ${options[i]}", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(context,"You unchecked  ${options[i]}", Toast.LENGTH_LONG).show()
        }
        .setPositiveButton("Accept"){_,_ ->
            Toast.makeText(context,"Accepted", Toast.LENGTH_LONG).show()
        }
        .setNegativeButton("Decline"){ _ , _ ->
            Toast.makeText(context,"Cancelled", Toast.LENGTH_LONG).show()
        }
        .create()

    val singleChoiceDialog: AlertDialog = AlertDialog.Builder(context)
        .setTitle("Choose on of the options")
        .setSingleChoiceItems(options,0){_,i ->
            Toast.makeText(context,"You clicked on ${options[i]}", Toast.LENGTH_LONG).show()
        }
        .setPositiveButton("Accept"){_,_ ->
            Toast.makeText(context,"Accepted", Toast.LENGTH_LONG).show()
        }
        .setNegativeButton("Decline"){ _ , _ ->
            Toast.makeText(context,"Cancelled", Toast.LENGTH_LONG).show()
        }
        .create()

}