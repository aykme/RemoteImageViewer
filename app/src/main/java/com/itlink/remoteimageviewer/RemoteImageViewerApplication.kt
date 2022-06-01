package com.itlink.remoteimageviewer

import android.app.Application
import com.itlink.remoteimageviewer.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class RemoteImageViewerApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory().create(applicationContext)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector
}