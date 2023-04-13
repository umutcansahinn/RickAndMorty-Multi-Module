package com.umutcansahin.common

fun Int?.orZero() = this ?: 0
fun <T> List<T>?.orEmptyList() = this ?: emptyList()
fun String?.orEmpty() = this ?: ""
fun Any?.orEmpty() = this ?: Any()