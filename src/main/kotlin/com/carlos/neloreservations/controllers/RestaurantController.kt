package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.services.RestaurantService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurants")
class RestaurantController(private val restaurantService: RestaurantService) {

    @GetMapping("/get")
    fun getRestaurants(): MutableIterable<Restaurant>{
        return restaurantService.findAll()
    }



}