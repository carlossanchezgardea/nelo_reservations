package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.models.json.CreateRestaurantRequest
import com.carlos.neloreservations.services.RestaurantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/restaurants")
class RestaurantController(private val restaurantService: RestaurantService) {

    @GetMapping("/get")
    fun getRestaurants(): MutableIterable<Restaurant>{
        return restaurantService.findAll()
    }

    @PostMapping("/create")
    fun createRestaurant(@RequestBody createRestaurantRequest: CreateRestaurantRequest): ResponseEntity<Restaurant> {
        val newRestaurant = restaurantService.createRestaurant(
            name = createRestaurantRequest.name,
            dietaryEndorsements = createRestaurantRequest.dietaryEndorsements
        )

        return ResponseEntity.ok().body(newRestaurant)
    }



}