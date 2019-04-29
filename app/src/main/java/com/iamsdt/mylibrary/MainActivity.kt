package com.iamsdt.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iamsdt.androidextension.BaseActivity
import com.iamsdt.androidextension.nextActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextActivity<MainActivity>()
    }
}
