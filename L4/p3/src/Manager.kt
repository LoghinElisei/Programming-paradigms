import java.io.*
class Manager (
    private val notes : MutableList<Note> = mutableListOf()
)
 {
    fun printNote(){
        val directory = File (".")
        val fileList =directory.walkTopDown().filter {
            it.isFile && it.extension == "txt"
        }.toList()

        if(fileList.isNullOrEmpty())
        {
            println("Empty folder")
        }
        else
        {
            for(file in fileList)
            {
                println(file.nameWithoutExtension)
            }
        }
    }

     fun deleteNote(title : String, filename : String){
         val note = notes.find{ it.title == title}
         if( note != null)
         {
             note.deleteNote(filename)
             notes.remove(note)
         }
         else
         {
             println("The given file title /note name is invalid")
         }
     }

     fun createNote(title: String, author: String, text: String, file: String): Note {
         val note = Note(title,author,text)
         note.saveNote(file)
         notes.add(note)
         return note

     }
}