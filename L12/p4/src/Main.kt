import java.util.Locale
import java.util.Locale.getDefault

fun addTestPrefix(value : String) = "Test $value"

fun String.toPascalCase():String{
    val components = this.split(" ")
    var result = ""
    for(component in components){
        result += component.replaceFirstChar { if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString() }
    }
    return result
}

class MapFunctor<T,K>(val map: Map<T,K>)
{
    fun map(function: (K) -> K) : MapFunctor<T,K>{
        var result = mutableMapOf<T,K>()
        for((key,value) in map){
            result[key] = function(value)
        }
        return MapFunctor(result)
    }

    override fun toString(): String {
        return map.toString()
    }
}


fun main() {

    val map1 = mapOf(1 to "one hour ", 2 to "two hours 2 second", 3 to "three hours 2 minutes")
    println(MapFunctor(map1).map( ::addTestPrefix).map{it.toPascalCase()})

//    val map2 = mapOf(4 to "fours hours " , 5 to "five hours 2 minutes")
//    println(MapFunctor(map2).map( )

}