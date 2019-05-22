package com.iamsdt.mylibrary

import android.app.Application
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

object NetworkData : LiveData<Boolean>() {

    private lateinit var application: Application
    private lateinit var netWork: NetworkRequest


    fun init(application: Application) {
        this.application = application
        netWork = NetworkRequest.Builder()
            //.addTransportType()
            .build()
    }

    override fun onActive() {
        super.onActive()
    }

}
