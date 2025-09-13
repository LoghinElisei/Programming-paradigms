package org.example

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.TimeUnit

class PostRequest {
    private val genericReq : GenericRequest

    constructor(url: String, params : Map<String,String>)
    {
        this.genericReq = GenericRequest(url,params)
    }
    fun postData(): Response
    {
        try{
            val client = OkHttpClient()
            val request : Request = Request.Builder().url(genericReq.url).get().build()
            return client.newCall(request).execute()
        }
        catch (  e : Exception)
        {
            println("Couldn't get a response")
            throw e
        }
    }
}