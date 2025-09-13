interface PaymentMethod {
    fun pay(fee : Double) : Boolean
    //fun updateAmount(fee: Double)
}