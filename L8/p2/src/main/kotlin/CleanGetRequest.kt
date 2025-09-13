package org.example

import okhttp3.Response

class CleanGetRequest : HTTPGet{
    private val getRequest : GetRequest
    private val parentalControlDissalow : List<String>

    constructor(getReq: GetRequest)
    {
        this.getRequest = getReq
        parentalControlDissalow = listOf()
    }

    override fun getResponse(): Response {
        val response = getRequest.getResponse()

        val responseBody = response.body?.string() ?: ""
        if (parentalControlDissalow.any{ responseBody.contains(it,ignoreCase = true)})
            throw IllegalArgumentException("Restricted content ... ")

        return response
    }
}