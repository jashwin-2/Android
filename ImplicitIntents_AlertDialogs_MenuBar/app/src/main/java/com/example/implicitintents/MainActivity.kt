package com.example.implicitintents

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialogs = Dialogs(this)
        val addPhotoDialog = AlertDialog.Builder(this)
            .setTitle("Add Photo")
            .setMessage("Do you want choose a photo ?")
            .setIcon(R.drawable.ic_photo)
            .setPositiveButton("Yes"){_,_ ->
                Intent(Intent.ACTION_GET_CONTENT).also {
                    it.type = "image/*"
                    startActivityForResult(it,0)
                }
            }
            .setNegativeButton("No"){_ , _ ->
                Toast.makeText(this,"Cancelled", Toast.LENGTH_LONG).show()
            }
            .create()
        btnChoose.setOnClickListener{
            addPhotoDialog.show()
        }
        btnSingleChoice.setOnClickListener{
            dialogs.singleChoiceDialog.show()
        }
        btnMulti.setOnClickListener{
            dialogs.multiChoiceDialog.show()
        }
    }
    //menu Bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

//on ItemSelected

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this,"You clicked on add Contact",Toast.LENGTH_SHORT).show()
            R.id.miFavorite -> Toast.makeText(this,"You clicked on Favorite",Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this,"You clicked on Settings",Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode ==0)
        {
            val uri = data?.data
            ivPhoto.setImageURI(uri)
        }
    }


}