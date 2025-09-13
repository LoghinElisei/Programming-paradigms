import java.io.*

fun MutableMap<String,String>.add(word : String , roWord : String)
{
    if ( this.containsKey(word)) {
        println("The '$word' exist yet")
    }
    else{
        this[word] = roWord;
    }
}

fun readDictionary( file : String ):HashMap<String,String>
{
    val dictionar = hashMapOf<String,String>()

    try{
        File(file).forEachLine { line ->
            val text = line.split(" ")
           // println(text)
            if (text.size == 2) {
                dictionar[text[0].trim()] = text[1].trim()
            } else {
                throw Error("Translate not given")
            }
        }
    }
    catch (e : Error){
        println("Translate must be given or many words")
    }
    catch (e : IOException){
        println("Error reading")
    }

    return dictionar
}

fun main(args : Array<String>){
    var Dictionar = hashMapOf<String, String>(
        "Once"                to  "Odata",
        "upon"                to  "ca",
        "a"                   to  "",
        "time"                to  "niciodata",
        "there"               to  "acolo",
        "was"                 to  "a fost",
        "an"                  to  "o",
        "old"                 to  "batrana",
        "woman"               to  "femeie",
        "who"                 to  "care",
        "loved"               to  "iubea",
        "baking"              to  "sa gateasca",
        "gingerbread"         to  "turta dulce",
        "She"                 to  "Ea",
        "would"               to  "ar fi",
        "bake"                to  "gatit",
        "gingerbread"         to  "turta dulce",
        "cookies"             to  "biscuiti",
        "cakes"               to  "prajituri",
        "houses"              to  "case",
        "and"                 to  "si",
        "people"              to  "oameni",
        "all"                 to  "toti",
        "decorated"           to  "decorati",
        "with"                to  "cu",
        "chocolate"           to  "ciocolata",
        "peppermint"          to  "menta",
        "caramel"             to  "caramel",
        "candies"             to  "bomboane",
        "colored"             to  "colorate",
        "ingredients"         to  "ingrediente"
    )

    val Poveste = "Once upon a time there was an old woman who loved baking gingerbread. She would bake gingerbread cookies, cakes, houses and gingerbread people, all decorated with chocolate and peppermint, caramel candies and colored ingredients."

    val words1 = Poveste.split(" ")

    println("Cuvintele din poveste [${words1.count()}]:")
    for (word in words1)
        print(word + " ")

    val words2 = mutableListOf<String>()
    for (word in words1){
        words2.add(word.trim(',','.'))
    }
    println("\n")
    println("Povestea tradusa ar suna cam asa:")

    Dictionar.add("cook","gateste")


    val writer = PrintWriter("translate.txt")
    for (item in words2){
        if (Dictionar.contains(item))
           writer.write(Dictionar[item])
        else
            writer.write("[$item]")
        writer.write(" ")
    }
    writer.close()

    var Dictionar2 = readDictionary("data.in")
    for (item in words2){
        if (Dictionar2.contains(item))
            print(Dictionar[item])
        else
            print("[$item]")
        print(" ")
    }
}