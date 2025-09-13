package org.example

class GenericRequest  : Cloneable{
    val url : String
    val params : Map<String,String>?

    constructor(url : String , params: Map<String, String>?)
    {
        this.url = url
        this.params = params
    }

    override fun clone(): GenericRequest {
        return this.clone()
    }
}