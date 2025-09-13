import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun readFile( fileName : String ) : List<String>
{
    return File(fileName).bufferedReader().readLines()
}

fun swapWords()
{
    val content = readFile("data.txt")
    val words = content.flatMap{it.split(" ")}
    println(words)

    var result : String =""
    words.forEach{ if(it.length >= 4 && it.length <= 7)
                result+="Caesar " else result+=it+" "}

    println(result)
}

fun main() {

    swapWords()
}