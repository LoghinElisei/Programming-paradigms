import java.io.File
import java.io.IOException

fun processEbook( ebookTxt : String): String{

    var text = ebookTxt
    text = text.replace(Regex("\\s+\\d+"),"") // page nr.

    text = text.replace(Regex("\\s+")," ")  // multiple space

    text = text.replace(Regex("\\n+"),"\n") // multiple new line

    val autor =(Regex("(\\b[A-Z][a-z]+\\s[A-z][a-z]+\\b)(?=.*\\1)")) // autor name
    text = text.replace(autor,"")

    text = text.replace(Regex("\\bCapitolul\\s+[A-Z][a-z]+\\b"),"")

    return text
}

fun main() {
    try {
        val book = File("ebook.txt").readText()
        val ebook = processEbook(book)
        println(ebook)
    }
    catch( e: IOException){
        println("Error reading")
    }



}