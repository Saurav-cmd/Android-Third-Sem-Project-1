package com.saurav1201474.myapplication.constants

object ImageConcat {
    fun concatImage(baseUrl:String,imageUrl:String):String{
       return "$baseUrl$imageUrl"
    }
}