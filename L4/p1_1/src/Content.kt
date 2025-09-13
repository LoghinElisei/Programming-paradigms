class Content (
    private var author : String,
    private var text : String,
    private var name : String,
    private var publisher : String
) {
    fun getAuthor() :String {
        return author
    }
    fun setAuthor( author : String){
        this.author = author
    }
    fun getText() : String{
        return text
    }
    fun setText(text : String) {
        this.text = text
    }
    fun getName() : String{
        return name
    }
    fun setName(name: String){
        this.name = name
    }
    fun getPublisher() : String{
        return publisher
    }
    fun setPublisher(publisher: String){
        this.publisher = publisher
    }

}