package com.itlink.remoteimageviewer

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.itlink.remoteimageviewer.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class RemoteImageViewerApplication : Application(), HasAndroidInjector, ImageLoaderFactory {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory().create(applicationContext)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }
}