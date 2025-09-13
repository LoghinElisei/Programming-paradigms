class Person (
    private val name : String,
    private val ticket : Ticket
) : BuyTicket{
    override fun buyTicket(payMethod : PaymentMethod)
    {
        val tiketPrice = ticket.getPrice()
        val payDone = payMethod.pay(tiketPrice)

        if(payDone )
        {
            println("The ticket with price ${tiketPrice} to the event ${ticket.getEventName()} has been buyed")
        } else{
            println("Error buying the ticket . No enough amount")
        }
        //payMethod.updateAmount(tiketPrice)
    }
}