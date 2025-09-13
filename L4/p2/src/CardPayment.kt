import java.lang.IllegalArgumentException

class CardPayment(
    private var bankAccount : BankAccount
) : PaymentMethod{
    override fun pay(fee: Double): Boolean {
        try{
            val ok = bankAccount.updateAmount(fee)

            if( !ok )
            {
                throw IllegalArgumentException("No enough bank amount")
            }
            return true
        }
        catch ( e : IllegalArgumentException)
        {
            println("No enough bank amount")
            return false
        }

    }

}