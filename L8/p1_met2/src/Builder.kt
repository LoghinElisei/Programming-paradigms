interface Builder {
    fun addInput(input : Int) : ANDBuilder
    fun build() : Gate
    fun getInputs() : List<Int>
}
