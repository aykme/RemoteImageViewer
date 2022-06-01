package com.itlink.remoteimageviewer.ui.imagelist.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.itlink.remoteimageviewer.di.AppScope
import com.itlink.remoteimageviewer.di.FragmentScope
import com.itlink.remoteimageviewer.domain.model.Image
import javax.inject.Inject

@FragmentScope
class ImageDiffCallback @Inject constructor() :
    DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}