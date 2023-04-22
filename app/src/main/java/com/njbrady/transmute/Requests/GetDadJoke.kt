package com.njbrady.transmute.Requests

import android.util.Log
import com.njbrady.transmute.Library.RequestMethods
import com.njbrady.transmute.Library.Tracer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.URL

suspend fun getDadJoke(){
    withContext(Dispatchers.IO) {
        val staticUrl = "http://icanhazdadjoke.com/"
        val tracer = Tracer(
            url = URL(staticUrl),
            requestMethod = RequestMethods.GET,
            doOutput = false,
            requestProperties = mapOf("Accept" to "application/json", "Content-Type" to "application/json", "User-Agent" to "Postman/7.32.2", "Connection" to "keep-alive", "Accept-Encoding" to "gzip, deflate, br"),
            toSend = emptyMap(),
            onResponse = { connection, responseCode ->
                val response = connection.inputStream.bufferedReader().use { it.readText() }
                val outputJson = JSONArray(response)
                Log.e("GETDADJOKE", outputJson.toString())
            },
            onErrorWithRequest = {}
        )
    }
}