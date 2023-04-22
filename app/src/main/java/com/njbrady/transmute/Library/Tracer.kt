package com.njbrady.transmute.Library

import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


enum class RequestMethods { GET, POST }

fun RequestMethods.toString(): String {
    return when (this) {
        RequestMethods.GET -> "GET"
        RequestMethods.POST -> "POST"
    }
}

class Tracer(
    url: URL,
    requestMethod: RequestMethods,
    doOutput: Boolean,
    requestProperties: Map<String, String>,
    toSend: Map<String, String>,
    onResponse: (HttpURLConnection, Int) -> Unit,
    onErrorWithRequest: (Exception) -> Unit
) {
    private val connection = url.openConnection() as HttpURLConnection
    private val toSendJson = JSONObject(toSend).toString()

    init {
        connection.instanceFollowRedirects = true
        try {
            connection.requestMethod = requestMethod.toString()
            connection.doOutput = doOutput
            connection.doInput = true
            for (item in requestProperties) {
                connection.addRequestProperty(item.key, item.value)
            }
            if (doOutput) {
                connection.outputStream.use {
                    it.write(toSendJson.toByteArray())
                }
            }

            onResponse(connection, connection.responseCode)
        } catch (e: Exception) {
            onErrorWithRequest(e)
        }
    }


}