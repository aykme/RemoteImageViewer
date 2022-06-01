package com.itlink.remoteimageviewer.data.mapper

import com.itlink.remoteimageviewer.domain.model.Image

fun List<String>.toImageList(): List<Image> {
    return this.map {
        Image(
            url = it
        )
    }
}
