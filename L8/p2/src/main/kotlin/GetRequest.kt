package org.example

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.TimeUnit

class GetRequest : HTTPGet{
    private val timeout : Int
    private val genericReq : GenericRequest

    constructor( url : String , params : Map<String,String> , timeout : Int)
    {
        this.timeout = timeout
        this.genericReq = GenericRequest(url,params)
    }

    override fun getResponse() : Response
    {
        try{
            val client = OkHttpClient.Builder().connectTimeout(timeout.toLong(),TimeUnit.SECONDS).build()
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