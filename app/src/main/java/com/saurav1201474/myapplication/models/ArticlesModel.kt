package com.saurav1201474.myapplication.models

data class ArticlesModel(
    val abstract:String,
    val web_url:String,
    val lead_paraghaph:String,
    val source:String,
    val multimedia:List<ImagesData>
)

data class ImagesData(
    val rank:Int,
    val url: String,
    val crop_name:String,
)
