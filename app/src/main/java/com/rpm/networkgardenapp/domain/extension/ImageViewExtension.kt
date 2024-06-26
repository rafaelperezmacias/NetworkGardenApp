package com.rpm.networkgardenapp.domain.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}