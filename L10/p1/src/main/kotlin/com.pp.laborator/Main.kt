package com.pp.laborator

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.*


// next1 -> the same chain
// next2 -> descend on the second chain
// next3 -> backwards in second chain

fun main() = runBlocking<Unit> {
    val factoryProducer = FactoryProducer()
    val eliteFactory = factoryProducer.getFactory("Elite")
    val happyWorkerFactory = factoryProducer.getFactory("HappyWorker")

    val CEOHandler1 = eliteFactory.getHandler("CEO")
    val CEOHandler2 = eliteFactory.getHandler("CEO")
    val executiveHandler1 = eliteFactory.getHandler("Executive")
    val executiveHandler2 = eliteFactory.getHandler("Executive")
    val managerHandler1 = eliteFactory.getHandler("Manager")
    val managerHandler2 = eliteFactory.getHandler("Manager")
    val happyWorkerHandler1 = happyWorkerFactory.getHandler("")
    val happyWorkerHandler2 = happyWorkerFactory.getHandler("")

    // 1'st chain
    CEOHandler1.setNext(executiveHandler1,null,null)
    executiveHandler1.setNext(managerHandler1,executiveHandler2,null)
    managerHandler1.setNext(happyWorkerHandler1,managerHandler2,null)
    happyWorkerHandler1.setNext(null,happyWorkerHandler2,null)

    // 2'st chain
    CEOHandler2.setNext(executiveHandler2,null,CEOHandler1)
    executiveHandler2.setNext(managerHandler2,null,CEOHandler2)
    managerHandler2.setNext(happyWorkerHandler2, null, executiveHandler2)
    happyWorkerHandler2.setNext(managerHandler2,null,null)


    val message1 = "2:Take an overview datasheet"
    //CEOHandler1.handleRequest(message1)
    //delay(1000)
    //CEOHandler1.handleRequest("1: Commit your changes")
    //CEOHandler1.handleRequest("3: You must take a meet with HR")
    CEOHandler1.handleRequest("4: I want you to work 2 extra hours")
}