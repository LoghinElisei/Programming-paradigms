package org.example
import kotlinx.serialization.*
import kotlinx.serialization.json.*

class JsonParser : Parser{
    override fun parse(text: String): Map<String,Any> {
        val json = Json.parseToJsonElement(text).jsonObject
        return json.mapValues { it.value.jsonPrimitive.content }
    }
}