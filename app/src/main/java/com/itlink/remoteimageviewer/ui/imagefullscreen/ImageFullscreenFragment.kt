package com.itlink.remoteimageviewer.ui.imagefullscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itlink.remoteimageviewer.databinding.FragmentImageFullscreenBinding
import com.itlink.remoteimageviewer.ui.MainActivity
import com.itlink.remoteimageviewer.util.bindImageView

const val CURRENT_IMAGE_URL = "imageUrl"

class ImageFullscreenFragment : Fragment() {
    private lateinit var binding: FragmentImageFullscreenBinding
    private var currentImage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentImage = it.getString(CURRENT_IMAGE_URL).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImageFullscreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageFullscreen.bindImageView(currentImage)
        binding.imageFullscreen.setOnClickListener {
            changeActionBarVisibility()
        }
    }

    private fun changeActionBarVisibility() {
        val actionBar = (activity as MainActivity).supportActionBar
        if (actionBar!!.isShowing) {
            actionBar.hide()
        } else {
            actionBar.show()
        }
    }
}