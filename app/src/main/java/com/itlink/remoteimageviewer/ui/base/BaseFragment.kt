package com.itlink.remoteimageviewer.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.itlink.remoteimageviewer.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}