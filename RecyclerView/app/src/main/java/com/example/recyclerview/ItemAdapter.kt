package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.recyclerview.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.another_item.view.*
import kotlinx.android.synthetic.main.item_custom_row.view.*

class ItemAdapter(private val context : Context, private val items : ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

companion object{
    val FIRST_TYPE = 1
    val SECOND_TYPE = 2
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType== FIRST_TYPE)
            ViewHolder(LayoutInflater.from(context).inflate(
                R.layout.item_custom_row
                ,parent
                ,false))
        else{
            AnotherViewHolder(LayoutInflater.from(context).inflate(
                R.layout.another_item,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if(holder is ViewHolder) {
            holder.tvItem.text = item.text
            holder.card?.setBackgroundColor(ContextCompat.getColor(context, R.color.light_gray))
        }
        else if(holder is AnotherViewHolder){
            holder.anotherTvItem.text = item.text
            holder.anotherCard?.setBackgroundColor(ContextCompat.getColor(context, R.color.light_gray))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }
    override fun getItemCount(): Int {
       return items.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvItem: TextView = view.tvTitle
        val card: CardView? = view.layoutCard
    }
    class AnotherViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var anotherTvItem: TextView = view.tvanotheritemtitle
        val anotherCard: CardView? = view.anotheritemlayoutCard
    }
}