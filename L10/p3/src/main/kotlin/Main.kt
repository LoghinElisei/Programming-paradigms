package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.ArrayDeque
import java.util.Queue
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

suspend fun CoroutineScope.massiveCalculus(action : suspend ()-> Unit){
    val n = 4 //numbers of coroutines
    val k = 1 //

    val time = measureTimeMillis {
        val jobs = List(n)
        {
            launch { repeat(k) { action()} }
        }
        jobs.forEach { it.join() }
    }

    println("S-au terminat cele ${n*k} corutine in $time ms")
}

suspend fun calculateSum(n : Int) : Long{
    return (0..n).sumOf { it.toLong()}
}

val queue = ArrayDeque(listOf<Int>(100,15,2000000,50))
val mutexQueue = Mutex()

val mtContext = newFixedThreadPoolContext(4,"mtpool")
fun main() = runBlocking<Unit>{
    CoroutineScope(mtContext).massiveCalculus {
        val n: Int? = mutexQueue.withLock {
            if (queue.isNotEmpty()) queue.removeFirst() else null
        }
        if (n != null) {
            val sum = calculateSum(n)
            println("Suma de la 0 la $n este $sum")

        }
        else
        {
            println("Coada goala")
        }
    }
}