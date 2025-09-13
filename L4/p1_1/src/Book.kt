class Book(
    private var data : Content

) {
    override fun toString(): String{
        return "Title : ${data.getName()}\n" +
                "Author: ${data.getAuthor()}\n" +
                "Publisher : ${data.getPublisher()}\n" +
                "Text : ${data.getText()}\n"
    }
    fun getName() : String = data.getName()
    fun getAuthor() : String = data.getAuthor()
    fun getPublisher() : String = data.getPublisher()
    fun getContent() : String = data.getText()
    fun hasAuthor(author : String): Boolean = data.getAuthor().equals(author)
    fun hasTitle(title :String) : Boolean = (data.getName().equals(title))
    fun isPublishedBy(publisher : String) : Boolean=data.getPublisher().equals(publisher)

}

class BookPrice(
    public val book : Book,
    private val price : Double
){
    fun getPrice() = price
}