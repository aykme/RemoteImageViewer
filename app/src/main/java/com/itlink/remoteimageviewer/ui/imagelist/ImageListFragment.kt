package com.itlink.remoteimageviewer.ui.imagelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.itlink.remoteimageviewer.databinding.FragmentImageListBinding
import com.itlink.remoteimageviewer.ui.base.BaseFragment
import com.itlink.remoteimageviewer.ui.imagelist.recyclerview.ImageListAdapter
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
        imageListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
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

        viewModel.refreshImageList()
        viewModel.imageListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}