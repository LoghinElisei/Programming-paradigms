import java.util.Scanner


fun main() {
    println("Enter the Type Of AND Gate : 2/3/4/6/8")
    val scanner = Scanner(System.`in`)
    val option = scanner.nextInt()
    val builder = ANDBuilder(option)
    var input = 1
    println("Enter the $option input signal")
    var i = 1
    println("Enter the signal input [0/1] or [-1] to exit")
    while ( input != -1)
    {
        print("BIT [$i] = ")
        input=scanner.nextInt()
        if(input == -1)
        {
            break
        }
        if(input < 0 || input > 1)
        {
            println("Invalid BIT signal")
        }
        else
            builder.addInput(input)
    }
    val gate = builder.build()
    val output = gate.output(builder.getInputs())
    println("Output = $output")
}