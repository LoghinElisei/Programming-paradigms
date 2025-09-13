class User (
    private val name : String
) : ComputeNote{
    override fun createNote(title: String, author: String, text: String , file : String): Note
    {
        val note = Note(title,author,text)
        note.saveNote(file)
        return note
    }

    override fun deleteNote(note: Note, file: String) {
        note.deleteNote(file)
    }
}