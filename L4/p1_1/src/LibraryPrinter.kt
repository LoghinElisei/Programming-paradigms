class LibraryPrinter : BookPrinter , HTMLPrinter , JSONPrinter {
    override fun printBooksRaw(books: MutableSet<Book>) {
        for(book in books)
        {
            println(book.toString())
        }
    }

    override fun printHTML(books: MutableSet<Book>) {
        for(book in books)
        {
            println("****** HTML STYLE ******")
            println(book.toString())
        }
    }

    override fun printJSON(books: MutableSet<Book>) {
        for(book in books)
        {
            println("****** JSON STYLE ******")
            println(book.toString())
        }
    }
}