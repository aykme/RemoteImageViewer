package com.itlink.remoteimageviewer.util

import android.widget.ImageView
import androidx.core.net.toUri
import coil.load
import com.itlink.remoteimageviewer.R

fun ImageView.bindImageView(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        this.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_image_error_24)
        }
    }
}
