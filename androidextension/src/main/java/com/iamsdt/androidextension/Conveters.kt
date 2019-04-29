/*
 *
 * Developed by Shudipto Trafder.
 * On 1/22/19 9:37 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

fun CharSequence.toDouble(): Double {
    val sequence = this.toString()
    return sequence.toDoubleOrNull() ?: 0.0
}

fun CharSequence.toCapFirst(): String {
    val c = this[0].toUpperCase()
    val s = this.toString()
    return s.replaceFirst(this[0], c)
}