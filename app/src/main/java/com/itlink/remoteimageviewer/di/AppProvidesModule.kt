package com.itlink.remoteimageviewer.di

import com.itlink.remoteimageviewer.data.remote.RemoteImageService
import com.itlink.remoteimageviewer.data.repository.RemoteImageRepositoryImpl
import com.itlink.remoteimageviewer.domain.repository.RemoteImageRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
class AppProvidesModule {

    @AppScope
    @Provides
    fun provideRemoteImageRepository(
        remoteImageService: RemoteImageService,
    ): RemoteImageRepository = RemoteImageRepositoryImpl(remoteImageService, Dispatchers.IO)
}