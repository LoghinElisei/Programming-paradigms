class Ticket(
    private val price : Double,
    private val eventName : String
) {
    fun getPrice() : Double = price
    fun getEventName() : String = eventName
}