import java.time.LocalDateTime

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val noteA = Note("First Note","Me"
        ,"Să se proiecteze (diagrama UML de clase) și să se implementeze respectând principiile\n" +
                "SOLID, o aplicație de notițe. Acestea pot fi salvate pe disk în fișiere individuale. Printr-un\n" +
                "meniu de tip CLI, aplicația va permite la pornirea acesteia")

    noteA.saveNote("data.txt")


    val userA = User("Me")
    userA.createNote("ABASD","ANONY","%^&$^#$#^@","t1.txt")

    val manager = Manager()
    val user = User("admin")
    while ( true )
    {
        println("\tChoose an option\n" +
                "1. Print notes\n" +
                "2. Create a new note\n" +
                "3. Delete a note\n" +
                "4. Exit")
        print("->> ")

        when ( readLine()?.toIntOrNull()){
            1 -> manager.printNote()
            2 -> {
                print("Title = ")
                val title = readLine()?:""
                print("Author = ")
                val author = readLine()?:""
                print("Filename = ")
                val file = readLine()?:""
                print("Content = ")
                val text = readLine()?:""
                manager.createNote(title,author,text,file)
            }
            3-> {
                print("Title = ")
                val title = readLine()?:""
                print("Filename = ")
                val file = readLine()?:""
                manager.deleteNote(title,file)
            }
            4-> break
            else -> println("Incorrect option")
        }
    }
}