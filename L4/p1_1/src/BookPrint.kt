interface BookPrinter {
    fun printBooksRaw(books : MutableSet<Book>)
}

interface HTMLPrinter{
    fun printHTML(books : MutableSet<Book>)
}

interface  JSONPrinter{
    fun printJSON(books : MutableSet<Book>)
}

