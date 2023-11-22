package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.models.entities.DinerUser
import com.carlos.neloreservations.services.DinerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diners")
class DinerController(private val dinerService: DinerService) {


    @GetMapping("/get")
    fun findAll(): MutableIterable<DinerUser> {
        return dinerService.findAll()
    }

    @GetMapping("/{uuid}")
    fun findById(@PathVariable uuid: String): ResponseEntity<DinerUser>  {
        return ResponseEntity.ok().body(dinerService.findById(uuid))

    }
}