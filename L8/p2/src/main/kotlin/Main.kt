package org.example
import okhttp3.Request
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val getUrl = "https://jsonplaceholder.typicode.com/posts/1"
    val postUrl = "https://jsonplaceholder.typicode.com/posts"
    val params = mapOf(
        "title" to "PP",
        "body" to "Laborator 8",
        "userId" to "1"
    )
    val genericRequest = GenericRequest(getUrl,null)
    val getRequest = GetRequest(getUrl, emptyMap(),7000)
    val parentalControlDissalow = listOf("restricted","blocked","forbidden")
    val cleanGetRequest = CleanGetRequest(getRequest)
    val genericPostRequest = GenericRequest(postUrl,params)
    val postRequest = PostRequest(postUrl,params)
    val kidsBrowser = KidsBrowser(cleanGetRequest,postRequest)

    kidsBrowser.start()
}