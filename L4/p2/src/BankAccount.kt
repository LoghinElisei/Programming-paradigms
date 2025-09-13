import java.util.*

class BankAccount (
    private var availableAmount : Double,
    private val cardNumber : String,
    private val expirationDate : Date,
    private val cvvCode : Int,
    private val userName : String
) {
    fun updateAmount(value : Double) : Boolean
    {
        if(availableAmount < value)
        {
            return false
        }
        availableAmount -= value
        return true
    }

}