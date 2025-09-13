class CashPayment(
    private var availableAmount : Double
):PaymentMethod {
    override fun pay(fee: Double): Boolean {
        if(fee > availableAmount)
        {
            return false
        }
        availableAmount -= fee
        return true
    }
//    override fun updateAmount(fee : Double){
//        availableAmount -= fee
//    }
}