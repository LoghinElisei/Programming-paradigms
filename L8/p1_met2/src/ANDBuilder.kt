class ANDBuilder (
    private val nrInputs : Int
) : Builder{
    private var inputs : MutableList<Int> = mutableListOf()
    override fun addInput(input: Int) : ANDBuilder{
        if(inputs.size >= nrInputs)
        {
            throw IllegalStateException("Too many inputs")
        }
        inputs.add(input)
        return this
    }

    override fun build(): Gate {
        return when ( nrInputs){
            2 -> AND2()
            3 -> AND3()
            4 -> AND4()
            5 -> AND8()
            else ->throw Exception("Invalid AND Gate")
        }
    }

    override fun getInputs(): List<Int> {
        return inputs
    }
}