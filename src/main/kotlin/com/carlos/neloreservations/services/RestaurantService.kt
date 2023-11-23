package com.carlos.neloreservations.services

import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import com.carlos.neloreservations.repositories.RestaurantRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RestaurantService(private val restaurantRepository: RestaurantRepository) {

    fun findAll(): MutableIterable<Restaurant> {
        return restaurantRepository.findAll()
    }

    fun createRestaurant(name: String, dietaryEndorsements: ArrayList<DietaryRestrictionType>): Restaurant {
        val restaurant = Restaurant(
            name = name,
            createdAt = Date(),
            dietaryEndorsements = dietaryEndorsements
        )
        return restaurantRepository.save(restaurant)
    }

}