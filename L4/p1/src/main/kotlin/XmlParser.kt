package org.example
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilderFactory

class XmlParser : Parser {
    override fun parse(text: String): Map<String,Any> {
        val result = mutableMapOf<String,Any>()
        val fileDoc : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(text.byteInputStream())
        fileDoc.documentElement.normalize()
        val node = fileDoc.documentElement.childNodes

        for (i in 0..node.length-1){
            val x = node.item(i)
            if( x.nodeType == org.w3c.dom.Node.ELEMENT_NODE){
                result[ x.nodeName ] = x.textContent
            }
        }
        return result
    }
}