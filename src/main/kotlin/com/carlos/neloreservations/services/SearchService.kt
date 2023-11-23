package com.carlos.neloreservations.services

import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import com.carlos.neloreservations.repositories.DinerRepository
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val userReposry: DinerRepository,
    private val restaurantService: RestaurantService
) {

    fun getUserRestrictions(users: List<String>): Set<DietaryRestrictionType>{
        val restrictions = mutableSetOf<DietaryRestrictionType>()
        for (user in users) {
            val diner = userReposry.findById(user).get()
            restrictions.addAll(diner.dietaryRestrictions)
        }
        return restrictions
    }

    fun matchRestaurantEndorsements(users: List<String>): ArrayList<Restaurant>{
        val userRestrictions = getUserRestrictions(users) // get a set of the user groups restrictions
        val restaurants = ArrayList<Restaurant>() // create an empty arraylist of restaurants
        val allRestaurants = restaurantService.findAll() // get all restaurants from the database
        for (restaurant in allRestaurants) {
            if(restaurant.dietaryEndorsements.containsAll(userRestrictions)){
                restaurants.add(restaurant)
            }
        }
        return restaurants
    }

}