package com.itlink.remoteimageviewer.data.remote

import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.inject.Inject

val IMAGE_SERVICE_URL = URL("https://it-link.ru/test/images.txt")
const val IMAGE_EXAMINATION = "https://encrypted-tbn0.gstatic.com/images?q=tbn:"

class RemoteImageService @Inject constructor()  {
    val imageLinkList: List<String> by lazy {
        getImageLinks()
    }

    private fun getImageLinks(): List<String> {
        val imageLinkList = mutableListOf<String>()
        var imageLinkReader: BufferedReader? = null
        try {
            imageLinkReader = BufferedReader(InputStreamReader(IMAGE_SERVICE_URL.openStream()))
            var currentLink: String?
            while ((imageLinkReader.readLine()).also { currentLink = it } != null) {
                if (isCorrectImageLink(currentLink!!)) {
                    imageLinkList.add(currentLink!!)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("ImageLiseViewModel", "Ошибка соединения с сервером")
        } finally {
            imageLinkReader?.close()
        }

        return imageLinkList.toList()
    }

    private fun isCorrectImageLink(link: String): Boolean {
        return link.contains(IMAGE_EXAMINATION)
    }
}