package com.itlink.remoteimageviewer.domain.repository

import com.itlink.remoteimageviewer.domain.model.Image


interface RemoteImageRepository {
    suspend fun getImageList(): List<Image>
}