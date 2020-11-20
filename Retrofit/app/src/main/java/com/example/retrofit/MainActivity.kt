package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rf = Retrofit.Builder()
            .baseUrl(RetrofitInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        var API = rf.create(RetrofitInterface::class.java)
        var call = API.posts

        call?.enqueue(object:Callback<com.example.retrofit.Response?>{
            override fun onResponse(
                call: Call<com.example.retrofit.Response?>,
                response: Response<com.example.retrofit.Response?>
            ) {
                var postList : com.example.retrofit.Response = response.body() as com.example.retrofit.Response
                var post = arrayOfNulls<String>(postList.getData()!!.size)

                for (i in postList.getData()!!.indices) {
                    post[i] = "In the " + postList!!.getData()?.get(i)!!.title_en + " " + postList!!.getData()?.get(i)!!.values?.get(0)?.value.toString() + " traffic accidents"

                    var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_dropdown_item_1line, post)
                    listView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<com.example.retrofit.Response?>, t: Throwable) {
                println("Throwable -----------------------------  $t")
            }

        })
    }
}