class AndBuilder(val inVal:Int )
{
    private val andGate : And = And(inVal)
//    fun addInValue(value : Int)
//    {
//        andGate.inValues.add(value)
//    }
    fun build() : And
    {
        return andGate
    }
}