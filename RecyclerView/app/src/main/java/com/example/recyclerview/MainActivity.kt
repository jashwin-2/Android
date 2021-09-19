package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.SimpleCursorAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ItemAdapter(this,getItemList())
        recyclerView.adapter = itemAdapter
    }

    private fun getItemList(): ArrayList<Item> {
        val list = ArrayList<Item>()
        list.add(Item("Item 1",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 2",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 3",ItemAdapter.SECOND_TYPE))
        list.add(Item("Item 4",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 5",ItemAdapter.SECOND_TYPE))
        list.add(Item("Item 6",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 7",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 8",ItemAdapter.SECOND_TYPE))
        list.add(Item("Item 9",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 10",ItemAdapter.SECOND_TYPE))
        list.add(Item("Item 11",ItemAdapter.FIRST_TYPE))
        list.add(Item("Item 12",ItemAdapter.SECOND_TYPE))
        list.add(Item("Item 13",ItemAdapter.FIRST_TYPE))

        return list
    }
}