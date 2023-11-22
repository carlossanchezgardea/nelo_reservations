package com.carlos.neloreservations.services

import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.repositories.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantService(private val restaurantRepository: RestaurantRepository) {

    fun findAll(): MutableIterable<Restaurant> {
        return restaurantRepository.findAll()
    }

}