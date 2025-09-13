class And(
    val inNumber : Int = 0 ,
    val inValues : MutableList<Int>  = mutableListOf()

) : Gate{
    override fun out(): Int {

        var result = 1
        for ( value in inValues)
        {
            if(value == 0)
            {
                result = 0   // stop
                break
            }
            result *= value
        }
        return result
    }

    fun addInValue(value : Int)
    {
        inValues.add(value)
    }
}