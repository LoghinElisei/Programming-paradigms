package com.pp.laborator

interface AbstractFactory{
    fun getHandler(handler : String ) : Handler
}

class EliteFactory : AbstractFactory{
    override fun getHandler(handler: String): Handler {
        when(handler) {
            "CEO" -> return CEOHandler()
            "Executive" -> return ExecutiveHandler()
            else -> return ManagerHandler()
        }
    }
}

class HappyWorkerFactory : AbstractFactory{
    override fun getHandler(handler: String): Handler {
        return HappyWorkerHandler()
    }
}


class FactoryProducer{
    fun getFactory(choice : String) : AbstractFactory{
        when(choice){
            "Elite" -> return EliteFactory()
            else -> return HappyWorkerFactory()
        }
    }
}