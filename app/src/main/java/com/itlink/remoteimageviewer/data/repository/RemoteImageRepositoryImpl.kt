package com.itlink.remoteimageviewer.data.repository

import com.itlink.remoteimageviewer.data.mapper.toImageList
import com.itlink.remoteimageviewer.data.remote.RemoteImageService
import com.itlink.remoteimageviewer.domain.model.Image
import com.itlink.remoteimageviewer.domain.repository.RemoteImageRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteImageRepositoryImpl @Inject constructor(
    private val remoteImageService: RemoteImageService,
    private val dispatcher: CoroutineDispatcher,
) : RemoteImageRepository {
    override suspend fun getImageList(): List<Image> {
        return withContext(dispatcher) {
            val imageList = remoteImageService.imageLinkList.toImageList()
            imageList
        }

    }
}