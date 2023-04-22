package com.njbrady.transmute

import java.net.HttpURLConnection
import java.net.URL

fun Request() {
    val staticUrl = ""
    val url = URL(staticUrl)
    val connection = url.openConnection() as HttpURLConnection
}