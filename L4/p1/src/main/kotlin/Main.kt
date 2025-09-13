package org.example



fun main() {
    val urlXml = "https://www.w3schools.com/xml/note.xml"
    val urlJson = "https://jsonplaceholder.typicode.com/posts"
    val urlYaml = ""
    val crawler = Crawler(urlJson)

    crawler.processContent("xml")

}