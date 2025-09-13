

fun main() {

    val list = listOf(1,21,75,39,7,2,35,3,31,7,8)

    val list2 = list.filter { it >= 5}

    val list3=list2.chunked(2).map { (a,b) -> a to b }

    val list4= list3.map { (a,b) -> a*b }

    val list5 = list4.sum()

    println(list5)

}