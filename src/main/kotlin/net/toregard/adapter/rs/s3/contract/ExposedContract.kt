package net.toregard.adapter.rs.s3.contract

import java.lang.Exception
import java.lang.RuntimeException

sealed class ServiceResult;
data class Success (val ok : Boolean) : ServiceResult()
data class Failure (val message: String?) : ServiceResult()

interface ExposedContract {
    fun save(data : String,katalog : String = "") : ServiceResult
}

class DoSomeThingService {
    fun save(data: String, katalog: String) : Boolean
    {
        if(data.length==0) throw RuntimeException("Kan ikke være tom")
        else return true
    }
}

class ExposedContractImpl : ExposedContract {

    override fun save(data: String, katalog: String): ServiceResult {
            try {
                val result = DoSomeThingService().save(data,katalog)
               return Success(true)
        }catch (e : Exception){
            return Failure(e.message)
        }
    }
}