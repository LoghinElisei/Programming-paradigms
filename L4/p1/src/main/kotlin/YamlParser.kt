package org.example
import org.yaml.snakeyaml.Yaml
class YamlParser : Parser{
    override fun parse(text: String): Map<String,Any> {
        val yaml = Yaml()
        return yaml.load(text) as Map<String,Any>
    }
}