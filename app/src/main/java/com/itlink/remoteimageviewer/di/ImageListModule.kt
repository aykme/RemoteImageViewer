package com.itlink.remoteimageviewer.di

import androidx.recyclerview.widget.DiffUtil
import com.itlink.remoteimageviewer.domain.model.Image
import com.itlink.remoteimageviewer.ui.imagelist.recyclerview.ImageDiffCallback
import dagger.Binds
import dagger.Module

@Module
abstract class ImageListModule {
    @Binds
    abstract fun bindDiffCallback(imageDiffCallback: ImageDiffCallback): DiffUtil.ItemCallback<Image>
}