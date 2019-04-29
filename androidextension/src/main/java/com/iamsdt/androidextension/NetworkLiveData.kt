/*
 *
 * Developed by Shudipto Trafder.
 * On 4/13/19 11:01 AM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.*
import androidx.lifecycle.LiveData


object NetworkLiveData : LiveData<Boolean>() {

    private lateinit var application: Application

    private lateinit var networkRequest: NetworkRequest


    fun init(application: Application) {
        this.application = application
        networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()
    }

    fun isNetworkAvaiable(): Boolean {
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    override fun onActive() {
        super.onActive()
        getDetails()
    }


    private fun getDetails() {
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.registerNetworkCallback(networkRequest, object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network?) {
                super.onAvailable(network)
                postValue(true)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                postValue(false)
            }

            override fun onLost(network: Network?) {
                super.onLost(network)
                postValue(false)
            }
        })
    }

}