package com.pp.laborator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.contracts.contract


// next1 -> mai departe pe acelasi lant
// next2 -> cobor pe lantul de jos
// next3 -> ma intorc pe lant

interface Handler {
    suspend fun handleRequest( messageToBeProcessed : String)
    fun setNext(next1: Handler? , next2 : Handler? ,next3: Handler?)
}

class CEOHandler(
    var next1 : Handler? = null,
    var next2 : Handler? = null
): Handler{
    override suspend fun handleRequest(messageToBeProcessed: String) {
        val message = messageToBeProcessed.drop(2)
        val priority = messageToBeProcessed.get(0)
        println("Cerere ajunsa la *** CEO ***")
        if(messageToBeProcessed.equals("Stop"))
        {
            println("\t--- Task Finished ---")
        }
        else if(priority == '1') {
            coroutineScope {
                launch {
                    println("Sunt CEO si prelucrez mesajul : $message")
                    delay(2006)
                    next2?.handleRequest(messageToBeProcessed) // trimit jos pe lant
                }
            }
        } else{
            coroutineScope {
                launch {

                    delay(1500)

                    if (next2 != null) //sunt jos
                    {
                        println("Trimit cererea inapoi")
                        next2?.handleRequest("Stop")

                    } else {
                        println("Trimit cererea mai departe")
                        next1?.handleRequest(messageToBeProcessed)
                    }
                }
            }
        }
    }

    override fun setNext(next1: Handler?, next2: Handler?, next3: Handler?) {
        this.next1 = next1
        this.next2 = next3
    }
}

class ExecutiveHandler(
    var next1 : Handler? = null,
    var next2 : Handler? = null,
    var next3 : Handler? = null
): Handler{
    override suspend fun handleRequest(messageToBeProcessed: String) {
        val message = messageToBeProcessed.drop(2)
        val priority :Char = messageToBeProcessed.get(0)
        println("Cerere ajunsa la *** Executive ***")

        if(priority == '2')
        {
            if(next3 == null) // sunt pe lantul de sus
            {
                coroutineScope {
                    launch {
                        println("Sunt Executive si prelucrez mesajul : $message")
                        delay(1500)
                        next2?.handleRequest(messageToBeProcessed)
                    }
                }
            } 
            else{
                coroutineScope {
                    launch {
                        println("Trimit cererea inapoi ")
                        delay(1500)
                        next3?.handleRequest(messageToBeProcessed)
                    }
                }
            }
            
        }
        else{
            coroutineScope {
                launch {

                    if(next3 == null) // sunt sus
                    {
                        println("trimit cererea mai departe")
                        delay(2546)
                        next1?.handleRequest(messageToBeProcessed)
                    }
                    else {
                        println("Trimit cererea inapoi")
                        delay(2343)
                        next3?.handleRequest(messageToBeProcessed)
                    }

                }
            }
        }
    }

    override fun setNext(next1: Handler?, next2: Handler?, next3: Handler?) {
        this.next1 = next1
        this.next2 = next2
        this.next3 = next3
    }
}

class ManagerHandler(
    var next1 : Handler? = null,
    var next2 : Handler? = null,
    var next3 : Handler? = null
): Handler{
    override suspend fun handleRequest(messageToBeProcessed: String) {
        val message = messageToBeProcessed.drop(2)
        val priority :Char = messageToBeProcessed.get(0)
        println("Cerere ajunsa la *** Manager ***")

        if(priority == '3')
        {
            if(next3 == null) // sunt pe lantul de sus
            {
                coroutineScope {
                    launch {
                        println("Sunt Manager si prelucrez mesajul : $message")
                        delay(2000)
                        next2?.handleRequest(messageToBeProcessed)   // trimit pe lantul de jos
                    }
                }
            }
            else{
                coroutineScope {
                    launch {
                        println("Trimit cererea inapoi ")
                        delay(2700)
                        next3?.handleRequest(messageToBeProcessed)
                    }
                }
            }

        }
        else{
            coroutineScope {
                launch {
                    if(next3 == null)
                    {
                        println("Trimit cererea mai departe")
                        delay(3000)
                        next1?.handleRequest(messageToBeProcessed)
                    }
                    else {
                        println("Trimit cererea inapoi")
                        delay(3000)
                        next3?.handleRequest(messageToBeProcessed)
                    }
                }
            }
        }
    }

    override fun setNext(next1: Handler?, next2: Handler?, next3: Handler?) {
        this.next1 = next1
        this.next2 = next2
        this.next3 = next3
    }
}

class HappyWorkerHandler(
    var next1 : Handler? = null,
    var next2 : Handler? = null,
): Handler{
    override suspend fun handleRequest(messageToBeProcessed: String) {
        val message = messageToBeProcessed.drop(2)
        val priority: Char = messageToBeProcessed.get(0)
        println("Cerere ajunsa la *** HappyWorker ***")

       
            if(next1 == null) //trimit jos
            {
                println("Sunt HappyWorker si prelucrez mesajul : $message")
                delay(2500)
                next2?.handleRequest(messageToBeProcessed)
            }
            else{
                println("Trimit cererea inapoi")
                delay(3500)
                next1?.handleRequest(messageToBeProcessed)
            }
    }

    override fun setNext(next1: Handler?, next2: Handler?, next3: Handler?) {
        this.next1 = next1
        this.next2 = next2
    }
}