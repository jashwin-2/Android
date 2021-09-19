package com.example.contextprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class AcronymProvider : ContentProvider() {


    companion object{
        val PROVIDER_NAME = "com.example.contextprovider/AcronymProvider"
        val URL = "content://$PROVIDER_NAME/ACTABLE"
        val CONTENT_URI = Uri.parse(URL)
        val _ID = "_id"
        val NAME = "NAME"
        val MEANING = "MEANING"
    }
    lateinit var db : SQLiteDatabase

    override fun onCreate(): Boolean {
        var helper = MyHelper(context)
        db = helper.writableDatabase
        return db != null
    }
    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.actable"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("ACTABLE",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }
    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        values : Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("ACTABLE",cols,condition,values,null,null,order)
    }

    override fun delete(uri: Uri, condition: String?, values: Array<out String>?): Int {
        val count = db.delete("ACTABLE",condition,values)
        context?.contentResolver?.notifyChange(uri,null)
        return count

    }

    override fun update(uri: Uri, cv: ContentValues?, conditon: String?, values: Array<out String>?): Int {
        val count = db.update("ACTABLE",cv,conditon,values)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }
}