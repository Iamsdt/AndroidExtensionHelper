/*
 *
 * Developed by Shudipto Trafder.
 * On 4/11/19 10:16 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    protected val uiScope = MyCoroutineContext()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(uiScope)
    }
}