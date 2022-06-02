package com.itlink.remoteimageviewer.util

import android.widget.ImageView
import androidx.core.net.toUri
import coil.load
import com.itlink.remoteimageviewer.R

fun ImageView.bindImageView(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        /*val request = ImageRequest.Builder(context)
            .data(imgUrl)
            .size(ViewSizeResolver(this))
            .build()
        ImageLoader.invoke(context).enqueue(request)*/

        this.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_image_error_24)
        }
    }
}
