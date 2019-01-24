package net.toregard.adapter.rs.s3

import net.toregard.adapter.rs.s3.contract.*
import net.toregard.adapter.rs.s3.contract.ServiceResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {


    @GetMapping("/greeting")
    fun save(
            @RequestParam(value = "data",  defaultValue = "" ) data: String,
            @RequestParam(value = "katalog", defaultValue = "") katalog: String
    ) : ServiceResult = ExposedContractImpl().save(data,katalog)


}