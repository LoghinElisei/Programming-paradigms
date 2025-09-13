import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val ticket = Ticket(45.99,"UEFA CHAMPIONS LEAGUE")
    val person = Person("Stefan",ticket)
    val cashpay = CashPayment(573.4)
    person.buyTicket(cashpay)

    val card = CardPayment(BankAccount(2913.4,"23492304324", Date(2030,12,4),344,"Stefan"))
    val ticket2 = Ticket(23.43,"THE BEAUTY AND THE BEAST")
    val person2 = Person("Cristi" , ticket2)
    person2.buyTicket(card)

}