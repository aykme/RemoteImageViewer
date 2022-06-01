package com.itlink.remoteimageviewer.domain.usecase

import com.itlink.remoteimageviewer.di.FragmentScope
import com.itlink.remoteimageviewer.domain.repository.RemoteImageRepository
import javax.inject.Inject

@FragmentScope
class FetchImageListUseCase @Inject constructor(
    private val remoteImageRepository: RemoteImageRepository,
) {
    suspend operator fun invoke() = remoteImageRepository.getImageList()
}