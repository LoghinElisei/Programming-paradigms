import java.time.LocalDate
import java.time.LocalDateTime
import java.io.*

class Note (
    public val title : String,
    private val author : String,
    private val text : String,
    private val createDate : LocalDateTime = LocalDateTime.now()

) : FileNote{
    override fun saveNote(fileName : String) {
        val file = File(fileName)
        file.writeText("Title : $title\n" +
                "Author : $author\n" +
                "Create Date : $createDate\n" +
                "\t Content\n $text")
    }

    override fun deleteNote(filename : String) {
        val file = File(filename)
        if( file.exists())
        {
            file.delete()
        } else
        {
            println("File not found")
        }
    }
}