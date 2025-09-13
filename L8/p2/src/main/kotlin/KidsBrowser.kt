package org.example

class KidsBrowser {
    private val cleanGet: CleanGetRequest
    private val postReq : PostRequest?

    constructor(cleanReq : CleanGetRequest , postReq : PostRequest?)
    {
        this.cleanGet = cleanReq
        this.postReq = postReq
    }

    fun start()
    {
        try {
            val cleanResponse = cleanGet.getResponse()
            println("Clean get response received ...")

            postReq?.let {
                val postResponse = it.postData()
                println("Post response received ...")
            }
        }
        catch (e : Exception)
        {
            println("Error")
        }
    }
}