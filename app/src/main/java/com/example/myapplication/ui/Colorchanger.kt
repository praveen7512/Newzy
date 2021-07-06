package com.example.myapplication.ui

object Colorchanger {


    val color = arrayOf("#d72631","#a2d5c6","#077b8a","#5c3c92","#e2d810","#d9138a","#12a4d9","#e75874","#fbcbc9")
    var index = 1

    fun Getcolor() :String{


        return color[index++ % color.size]

    }
}