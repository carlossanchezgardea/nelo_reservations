package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.models.entities.DinerUser
import com.carlos.neloreservations.models.json.NewUserRequest
import com.carlos.neloreservations.services.DinerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/diners")
class DinerController(private val dinerService: DinerService) {


    @GetMapping("/get")
    fun findAllUsers(): MutableIterable<DinerUser> {
        return dinerService.findAll()
    }


    @GetMapping("/{uuid}")
    fun findById(@PathVariable uuid: String): ResponseEntity<DinerUser>  {
        return ResponseEntity.ok().body(dinerService.findById(uuid))

    }

    @PostMapping("/create")
    fun createDiner(@RequestBody request: NewUserRequest): ResponseEntity<DinerUser> {
        val savedDiner = dinerService.createDiner(
            firstName = request.firstName,
            lastName = request.lastName,
            dietaryRestrictions = request.dietaryRestriction
        )
        return ResponseEntity.ok().body(savedDiner)
    }
}