//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var a = Content("Ion Creanga","A fost odata ...","Amintiri din Copilarie","Carturesti")
    var b = Content("Mihai Eminescu","Cobori in jos ...","Luceafarul","Libris")
    var c = Content("Mihai Eminescu","Ca de n-ar fi nu s-ar povesti...","Fat-frumos din lacrima","Libris")
    var book1 = Book(a)
    var book2 = Book(b)
    var book3 = Book(c)
    var libra = Library(mutableSetOf( book1,book2,book3))
    val bookWithSameAuthor = libra.findAllByAuthor("Mihai Eminescu")

    println("\tBook with author Mihai Eminescu")
    for ( book in bookWithSameAuthor)
    {
        println(book.toString())
    }

    val library = Library(mutableSetOf( book1,book2,book3))
    library.addBooks(book1)
    library.addBooks(book3)
    val books = library.getBooks()
    for(book in books)
    {

    }
    library.print(1)

    val priceBook  = BookPrice(book1,99.99)
    println(priceBook.book.getName() + " -> " + priceBook.getPrice() + "lei")
}