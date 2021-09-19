package com.example.contextprovider
import android.provider.SyncStateContract.Helpers.insert
import android.content.ContentResolver
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rs = contentResolver.query(AcronymProvider.CONTENT_URI, arrayOf(AcronymProvider._ID,AcronymProvider.NAME
            ,AcronymProvider.MEANING),null,null,AcronymProvider.NAME)
        //view all data
        var adapter = SimpleCursorAdapter(applicationContext,android.R.layout.simple_expandable_list_item_2,rs,
            arrayOf(AcronymProvider.NAME,AcronymProvider.MEANING),
            intArrayOf(android.R.id.text1,android.R.id.text2),0)
        listview.adapter=adapter


        btnNext.setOnClickListener{
            if(rs?.moveToNext()!!)
            {
                etName.setText(rs.getString(1))
                etMeaning.setText(rs.getString(2))
            }
        }

        btnClear.setOnClickListener{
            etName.setText("")
            etMeaning.setText("")
            etName.requestApplyInsets()
        }

        btnPrevious.setOnClickListener{
            if(rs?.moveToPrevious()!!){
                etName.setText(rs.getString(1))
                etMeaning.setText(rs.getString(2))

            }
        }
        btnInsert.setOnClickListener{
            val cv = ContentValues()
            cv.put(AcronymProvider.NAME,etName.text.toString())
            cv.put(AcronymProvider.MEANING,etMeaning.text.toString())
            val dialog = AlertDialog.Builder(this).setMessage("Do you want to insert this ?")
                .setTitle("Insert")
                .setPositiveButton("Yes"){ _,_ ->
                    contentResolver.insert(AcronymProvider.CONTENT_URI,cv)
                    rs?.requery()
                    Toast.makeText(applicationContext,"Inserted Successfully",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){_ , _ ->

                }
            dialog.show()
        }
        btnUpdate.setOnClickListener{
            val cv = ContentValues()
            cv.put(AcronymProvider.MEANING,etMeaning.text.toString())
            contentResolver.update(AcronymProvider.CONTENT_URI,cv,"NAME = ?",
                arrayOf(etName.text.toString()))
            rs?.requery()
            Toast.makeText(applicationContext,"Updated Successfully",Toast.LENGTH_SHORT).show()
        }

        btnDelete.setOnClickListener{
            contentResolver.delete(AcronymProvider.CONTENT_URI,"NAME = ?", arrayOf(etName.text.toString()))
            rs?.requery()
            Toast.makeText(applicationContext,"Deleted Successfully",Toast.LENGTH_SHORT).show()
            etName.setText("")
            etMeaning.setText("")
            etName.requestApplyInsets()
        }
        btnviewall.setOnClickListener{
            listview.visibility= View.VISIBLE

        }
    }
}