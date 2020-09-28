package com.example.kotlinfishermenhandbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (listArray:ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayRecycler = listArray
    var contextRecycler = context

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val im = view.findViewById<ImageView>(R.id.im)

        fun bind( listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            im.setImageResource(listItem.image_id)

            itemView.setOnClickListener(){
                Toast.makeText(context, "Pressed : $tvTitle", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextRecycler)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayRecycler.get(position)
        holder.bind(listItem, contextRecycler)
    }

    override fun getItemCount(): Int {
        return listArrayRecycler.size
    }

    fun updateAdapter(listArray: List<ListItem>){
        listArrayRecycler.clear()
        listArrayRecycler.addAll(listArray)

        notifyDataSetChanged() // уведомить что произошло изменение
    }

}