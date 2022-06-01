package com.itlink.remoteimageviewer.util

import android.widget.ImageView
import androidx.core.net.toUri
import coil.load
import com.itlink.remoteimageviewer.R

object ImageUtil {
    fun bindImageView(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            imgView.load(imgUri) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_image_error_24)
            }
        }
    }
}