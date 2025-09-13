import java.util.Scanner


fun GateExecute()
{
    var rel = 1
    var nr : Int
    val scanner = Scanner(System.`in`)


    while (rel != 0)
    {
        print("Number of Inputs : ")
        nr = scanner.nextInt()
        if(nr % 2 == 1)
        {
            println("Number of Inputs must be Odd")
            continue
        }
        var AND = AndBuilder(nr).build()
        rel = 0
        println("Enter the inputs ")
        var nr_aux = nr
        while(nr_aux > 0)
        {

            var inVal = 1
            var ok = 1
            while ( ok != 0)
            {
                inVal = scanner.nextInt()
                if(inVal < 0 || inVal > 1)
                {
                    println("Value must be 1 or 0 ")
                    continue
                }
                ok = 0
            }

            ok=1
            AND.addInValue(inVal)
            nr_aux--;
        }
        println("Signal BIT : "+AND.out())
    }
}

fun main() {
    GateExecute()

    println()
}