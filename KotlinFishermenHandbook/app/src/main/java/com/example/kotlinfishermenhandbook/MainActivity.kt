package com.example.kotlinfishermenhandbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity() {
    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<ListItem>()

        list.addAll(
            fillArray(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_content),
                getImageId(R.array.fish_image_array)
            )
        ) // получить данные из array.xml

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    fun fillArray(titleArray:Array<String>, contentArray:Array<String>, imageArray:IntArray):List<ListItem> {
        var listItemArray = ArrayList<ListItem>()

        for(n in titleArray.indices) {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }

        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        var count = tArray.length()
        val ids = IntArray(count)

        for(i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle() // для возможности переиспользовать
        return ids
    }
}