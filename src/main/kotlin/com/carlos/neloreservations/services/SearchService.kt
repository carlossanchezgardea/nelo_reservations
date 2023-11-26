package com.carlos.neloreservations.services

import com.carlos.neloreservations.lib.Utils.DateConverter
import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import com.carlos.neloreservations.repositories.DinerRepository
import com.carlos.neloreservations.repositories.RestaurantTableRepository
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val userReposry: DinerRepository,
    private val restaurantService: RestaurantService,
    private val restaurantTableRepository: RestaurantTableRepository
) {

    private val dateConverter = DateConverter()

    // find user group dietary restrictions
    fun getUserRestrictions(users: List<String>): Set<DietaryRestrictionType> {
        val restrictions = mutableSetOf<DietaryRestrictionType>()

        for (user in users) {
            val diner = userReposry.findById(user).get()
            restrictions.addAll(diner.dietaryRestrictions)
        }

        return restrictions
    }

    // find restaurants that match user group dietary restrictions
    fun matchRestaurantEndorsements(users: List<String>): List<Restaurant> {
        val userRestrictions = getUserRestrictions(users) // get a set of the user groups restrictions
        val restaurants = ArrayList<Restaurant>() // create an empty arraylist of restaurants
        val allRestaurants = restaurantService.findAll() // get all restaurants from the database

        for (restaurant in allRestaurants) {
            if (restaurant.dietaryEndorsements.containsAll(userRestrictions)) {
                restaurants.add(restaurant)
            }
        }

        val reservedRestaurants = findAllTables(restaurants.map { it.uuid }).size
        println(reservedRestaurants)
//        val availableRestaurants = restaurants.filterNot { it.uuid in reservedRestaurants }

        return restaurants
        //TODO: reservedRestaurants returns a list of all of the tables that are returned from matchRestaurantEndorsements
        //TODO: add method to find all tables that are reserved for a given time
        //TODO: filter out all restaurants that have no available tables for the given time
    }

    fun findAllTables(restaurantsUuids: List<String>): List<String> {
        return restaurantTableRepository.finAllRestaurantTables(restaurantsUuids)
    }

//    fun findAllBookedTables(restaurantsUuids: List<String>, startTime: String ): List<String> {
//        return restaurantTableRepository.findAllBookedTables(restaurantsUuids)
//    }


}