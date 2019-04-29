/*
 *
 * Developed by Shudipto Trafder.
 * On 4/12/19 9:55 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class ScopeViewModel : ViewModel() {

    private val job = SupervisorJob()
    protected val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCleared() {
        super.onCleared()
        uiScope.coroutineContext.cancelChildren()
    }

}