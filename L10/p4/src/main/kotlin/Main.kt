package org.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import java.util.Scanner

suspend fun CoroutineScope.processFile( fileName : String) {
    println("\tThread ${Thread.currentThread().name}")
    println("Se proceseaza fisierul $fileName")
    delay(2000)
    println("Thread ${Thread.currentThread()} am terminat de procesat fisierul $fileName\n")
}

val mtContext = newFixedThreadPoolContext(4,"mtPool")
val files = listOf("file1","file2","file3","file4","file5")

suspend fun CoroutineScope.startFileProcess(){
    println("Incepe procesarea fisierelor")
    delay(1300)
    val scope = CoroutineScope(mtContext)
    val jobs = files.map {
            file -> scope.launch {
        scope.processFile(file) }
    }

    jobs.forEach { it.join() }
}

fun main(args: Array<String>) = runBlocking{
//    object : Thread() {
//        override fun run() {
//            println("Sunt in thread-ul singleton ${Thread.currentThread()}")
//        }
//    }.start()
//    CoroutineScope(mtContext).processFile( )

    CoroutineScope(mtContext).startFileProcess()
}


