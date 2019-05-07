/*
 *
 * Developed by Shudipto Trafder.
 * On 1/22/19 9:30 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension


import android.content.res.Configuration
import android.os.AsyncTask
import android.os.Build
import android.text.PrecomputedText
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

fun View.gone() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.changeHeight(height: Int) {
    requestLayout()
    layoutParams.height = height
}

fun TextView.addStr(string: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val params = this.textMetricsParams
        val weakReference = WeakReference(this)

        AsyncTask.execute {
            val text = PrecomputedText.create("Hello", params)
            val textView = weakReference.get()
            textView?.post {
                val textViewRef = weakReference.get()
                textViewRef?.text = text
            }
        }

    } else {
        this.text = string
    }
}

fun TextView.addStrK(string: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val params = this.textMetricsParams
        val weakReference = WeakReference(this)

        GlobalScope.launch(Dispatchers.IO) {
            val text = PrecomputedText.create("Hello", params)
            val textView = weakReference.get()
            textView?.post {
                val textViewRef = weakReference.get()
                textViewRef?.text = text
            }
        }

    } else {
        this.text = string
    }
}

fun Window.layout(size: Int) {
    if (context?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        setLayout(size, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}