package org.example
import org.jsoup.Jsoup

class RssItem (
    val title : String,
    val link : String,
    val description : String,
    val pubDate :String
)

class RssFeed(
    val title : String,
    val link : String,
    val description : String,
    val pubDate :String ,
    val items : MutableList<RssItem> = mutableListOf()
)

fun main() {

    val url = "http://rss.cnn.com/rss/edition.rss"
    val page = Jsoup.connect(url).get()

    val title = page.selectFirst("channel > title")?.text() ?:""
    val link = page.selectFirst("channel > link")?.text() ?:""
    val description = page.selectFirst("channel > description")?.text() ?:""
    val pubDate = page.selectFirst("channel > pubDate")?.text() ?:""

    val feed = RssFeed(title,link,description,pubDate)

    val items = page.select("channel > item")
    for (item in items) {
        val title = item.selectFirst("title")?.text() ?:""
        val link = item.selectFirst("link")?.text() ?:""
        val description = item.selectFirst("description")?.text() ?:""
        val pubDate = item.selectFirst("pubDate")?.text() ?:""
        val rss = RssItem(title,link,description,pubDate)
        feed.items.add(rss)
    }

    println("\t\tTitle : ${feed.title}")
    println("\t\tLink : ${feed.link}")
    println("\t\tpubDate : ${feed.pubDate}")

    var i = 1
    for(item in feed.items){
        println("\tItem ${i}")
        i++
        println("Title : ${item.title}")
        println("Link : ${item.link}")
    }
}