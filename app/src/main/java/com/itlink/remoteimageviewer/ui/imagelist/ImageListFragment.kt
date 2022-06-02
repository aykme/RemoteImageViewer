package com.itlink.remoteimageviewer.ui.imagelist

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.itlink.remoteimageviewer.databinding.FragmentImageListBinding
import com.itlink.remoteimageviewer.ui.base.BaseFragment
import com.itlink.remoteimageviewer.ui.imagelist.recyclerview.ImageListAdapter
import java.io.IOException
import javax.inject.Inject

class ImageListFragment : BaseFragment() {
    @Inject
    lateinit var adapter: ImageListAdapter
    private lateinit var binding: FragmentImageListBinding
    private val viewModel: ImageListViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentImageListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageListRecyclerView = binding.imageListRecyclerView
        if (isLandscapeOrientation()) {
            imageListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        } else {
            imageListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }
        imageListRecyclerView.adapter = adapter
        adapter.setOnItemClickedAction {
            val actionImageListFragmentToImageFullscreenFragment =
                ImageListFragmentDirections
                    .actionImageListFragmentToImageFullscreenFragment(
                        imageUrl = it.url
                    )
            view.findNavController()
                .navigate(
                    actionImageListFragmentToImageFullscreenFragment
                )
        }
        try {
            viewModel.refreshImageList()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(requireContext(),
                "",
                Toast.LENGTH_LONG).show()
        }


        viewModel.imageListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun isLandscapeOrientation(): Boolean {
        val orientation = resources.configuration.orientation
        return orientation == Configuration.ORIENTATION_LANDSCAPE
    }
}