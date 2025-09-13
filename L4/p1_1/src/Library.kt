class Library (
    private var books : MutableSet<Book> = mutableSetOf(),

){
    fun getBooks() : Set<Book> = books
    fun addBooks(book :Book){
        books.add(book)
    }
    fun findAllByAuthor(author : String) : MutableSet<Book>{
        var book : MutableSet<Book> = mutableSetOf()

        for( x in books)
        {
            if( x.getAuthor().equals(author))
            {
                book.add(x)
            }
        }
        return book
    }

    fun print(option : Int){
        val printer = LibraryPrinter()
        when(option){
            1 -> printer.printBooksRaw(books)
            2 -> printer.printHTML(books)
            3 -> printer.printJSON(books)
            else -> println("Invalid Option")
        }
    }

}