/*
 *
 * Developed by Shudipto Trafder.
 * On 1/22/19 9:30 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension


import android.content.res.Configuration
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView

fun View.gone(){
    visibility = View.GONE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.inVisible(){
    visibility = View.INVISIBLE
}

fun View.changeHeight(height: Int){
    requestLayout()
    layoutParams.height = height
}

fun TextView.addStr(string: String){
    this.text = string
}

fun Window.layout(size: Int) {
    if (context?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        setLayout(size, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}