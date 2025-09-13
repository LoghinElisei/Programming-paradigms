package org.example
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.Connection

class Crawler(private var url: String) {
    fun getResource(): Document =Jsoup.connect(url).get()


    fun processContent(contentType: String) {
        val document = getResource()
        val content = document.text()
        println(content)

        val parser : Parser = when(contentType.lowercase()){
            "json" -> JsonParser()
            "xml" -> XmlParser()
            "yaml" -> YamlParser()
            else -> throw IllegalArgumentException("Unknow parser type")
        }

        val result = parser.parse(content)
        println(result)
    }
}