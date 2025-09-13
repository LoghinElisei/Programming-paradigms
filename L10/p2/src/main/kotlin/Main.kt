package org.example
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking<Unit>{
    val alpha = 5
    var V : Array<Int> = arrayOf(4,32,1,95,100,12,423,234,1,32,23,34,876,4352)

    V.forEach { print("$it ")}
    println()
    launch(Dispatchers.Default) {
        println("\tThread1 -> multiply with ${alpha}")
        for (i in V.indices){
            V[i] *= alpha
        }
//        V.forEach { print("$it ") }
//        println()
    }.join()

    launch (Dispatchers.Default ){
        println("\n\tThread 2 -> Order")
        V.sort()
//        V.forEach { print("$it ") }
    }.join()

    launch (Dispatchers.Default ) {
        println("\n\tThread 3 -> Print")
        V.forEach { print("$it ")}
    }.join()

//    launch {  // contextul parinte - corutina functiei main cu runBlocking
//        print("Corutina principala runBlocking : Sunt in thread ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.Unconfined) {// not confined -- va lucra cu thread-ul principal
//
//        println("Independenta : Sunt in thread ${Thread.currentThread().name}")
//    }
//    launch (Dispatchers. Default){  // gestionata de DefaultDispatcher
//        println("Implicita : Sunt in thread ${Thread.currentThread().name}")
//    }
//    launch(newSingleThreadContext("Threadul Meu")) { // va primi propriul thread
//
//        println("newsSingleThreadContext: Sunt in thread ${Thread.currentThread().name}")
//    }
}