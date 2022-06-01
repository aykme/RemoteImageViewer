package com.itlink.remoteimageviewer.di

import android.content.Context
import com.itlink.remoteimageviewer.RemoteImageViewerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    ViewModelBuilder::class,
    ImageListModule::class,
    AppProvidesModule::class
])
interface AppComponent {
    fun inject(app: RemoteImageViewerApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}