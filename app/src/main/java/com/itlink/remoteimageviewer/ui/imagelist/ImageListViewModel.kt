package com.itlink.remoteimageviewer.ui.imagelist

import androidx.lifecycle.*
import com.itlink.remoteimageviewer.di.FragmentScope
import com.itlink.remoteimageviewer.domain.model.Image
import com.itlink.remoteimageviewer.domain.usecase.FetchImageListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@FragmentScope
class ImageListViewModel @Inject constructor(
    private val fetchImageListUseCase: FetchImageListUseCase,
) : ViewModel() {
    val imageListLiveData = MutableLiveData<List<Image>>()

    fun refreshImageList() {
        viewModelScope.launch {
                val imageList = fetchImageListUseCase()
                imageListLiveData.postValue(imageList)
        }
    }
}