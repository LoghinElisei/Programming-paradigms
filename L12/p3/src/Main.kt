import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt

fun readPolygonData(): MutableList<Pair<Int, Int>> {
    val scanner = Scanner(System.`in`)
    print("n = ")
    val n = scanner.nextInt()

    println("x y")
//    var xList = mutableListOf<Int>()
//    var yList = mutableListOf<Int>()

    val points = mutableListOf<Pair<Int, Int>>()

    for(i in 1..n)
    {
        val x = scanner.nextInt()
        val y = scanner.nextInt()

//        xList.add(x)
//        yList.add(y)

        points.add(Pair(x, y))
    }

    points += points.first()

    println(points)
    return points



//    val xCoordinates = xList.zipWithNext()
//    println(xCoordinates)
//    //xList.add(xList.size ,xList.last())
//    val xy = xList.chunked(2)
//
//
//    val yCoordinates = yList.zipWithNext()
//    println(yCoordinates)
//    val coordinates = xCoordinates.zip(yCoordinates)
//
//    scanner.close()
//
//    return coordinates
}

fun distance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Double {
    print(p1)
    println(" " + p2)
    println()

    return sqrt((p1.first - p2.first).toDouble().pow(2) + (p1.second - p2.second).toDouble().pow(2))
}

fun getPolygonPerimeter() : Double
{
    val points = readPolygonData()
    val line = points.zipWithNext()

    println(line)
    return line.sumOf { (A,B) -> distance(A,B)}
}
fun main() {

    println(getPolygonPerimeter())

    //0 0
    //0 1
    //1 1
    //1 0
}