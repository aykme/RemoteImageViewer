package com.itlink.remoteimageviewer.data.remote

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.inject.Inject

val IMAGE_SERVICE_URL = URL("https://it-link.ru/test/images.txt")

class RemoteImageService @Inject constructor()  {
    val imageLinkList: List<String> by lazy {
        getImageLinks()
    }

    private fun getImageLinks(): List<String> {
        val imageLinkList = mutableListOf<String>()
        val imageLinkReader = BufferedReader(InputStreamReader(IMAGE_SERVICE_URL.openStream()))
        var currentLink: String?
        while ((imageLinkReader.readLine()).also { currentLink = it } != null) {
            if (isCorrectImageLink(currentLink!!)) {
                imageLinkList.add(currentLink!!)
            }
        }
        imageLinkReader.close()
        return imageLinkList.toList()
    }

    private fun isCorrectImageLink(link: String): Boolean {
        return true
    }
}