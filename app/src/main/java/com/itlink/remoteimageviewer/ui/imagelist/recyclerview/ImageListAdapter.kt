package com.itlink.remoteimageviewer.ui.imagelist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itlink.remoteimageviewer.databinding.ItemImageListBinding
import com.itlink.remoteimageviewer.di.FragmentScope
import com.itlink.remoteimageviewer.domain.model.Image
import com.itlink.remoteimageviewer.util.bindImageView
import javax.inject.Inject

@FragmentScope
class ImageListAdapter @Inject constructor(
    diffCallback: DiffUtil.ItemCallback<Image>,
) :
    ListAdapter<Image, ImageListAdapter.ImageViewHolder>(diffCallback) {
    private lateinit var onItemClicked: (Image) -> Unit

    class ImageViewHolder(private val binding: ItemImageListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            image: Image,
            onItemClicked: (Image) -> Unit,
        ) {
            binding.itemImage.bindImageView(image.url)
            itemView.setOnClickListener {
                onItemClicked(image)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageListBinding.inflate(LayoutInflater.from(parent.context))
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = getItem(position)
        image?.let {
            holder.bind(image, onItemClicked)
        }
    }

    fun setOnItemClickedAction(onItemClicked: (Image) -> Unit) {
        this.onItemClicked = onItemClicked
    }
}