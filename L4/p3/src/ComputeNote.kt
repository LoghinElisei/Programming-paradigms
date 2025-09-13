interface ComputeNote {
    fun createNote(title : String, author : String, text : String , file :String): Note
    fun deleteNote(note : Note , file : String)
}