package com.umutcansahin.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageCircle(url: String?) {
    Glide.with(this)
        .load(url)
        .fitCenter()
        .circleCrop()
        .into(this)
}
fun ImageView.loadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .fitCenter()
        .into(this)
}