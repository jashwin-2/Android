package com.example.contextprovider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context?) : SQLiteOpenHelper(context,"ACDB",null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ACTABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MEANING TEXT )")
        db?.execSQL("INSERT INTO ACTABLE(NAME,MEANING) VALUES('MCA','Master of Comptuter Aplications')")
        db?.execSQL("INSERT INTO ACTABLE(NAME,MEANING) VALUES('BCA','Bachloer of Comptuter Aplications')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}