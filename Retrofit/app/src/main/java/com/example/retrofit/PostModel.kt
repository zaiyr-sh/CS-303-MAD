package com.example.retrofit

import com.google.gson.annotations.SerializedName


class PostModel {
    @SerializedName("pk")
    var pk = 0
    @SerializedName("priority")
    var priority = 0
    @SerializedName("title_en")
    var title_en:String? = null
    @SerializedName("title_kg")
    var title_kg:String? = null
    @SerializedName("title_ru")
    var title_ru:String? = null
    @SerializedName("values")
    var values: List<Values>? = null

}