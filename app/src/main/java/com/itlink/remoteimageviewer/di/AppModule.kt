package com.itlink.remoteimageviewer.di

import androidx.lifecycle.ViewModel
import com.itlink.remoteimageviewer.ui.imagelist.ImageListFragment
import com.itlink.remoteimageviewer.ui.imagelist.ImageListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ImageListModule::class])
    abstract fun contributeImageListInjector(): ImageListFragment

    @Binds
    @IntoMap
    @ViewModelKey(ImageListViewModel::class)
    abstract fun bindImageListViewModel(imageListViewModel: ImageListViewModel): ViewModel
}