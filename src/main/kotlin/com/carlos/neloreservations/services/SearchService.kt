package com.carlos.neloreservations.services

import com.carlos.neloreservations.lib.Utils.DateConverter
import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import com.carlos.neloreservations.repositories.DinerRepository
import com.carlos.neloreservations.repositories.RestaurantRepository
import com.carlos.neloreservations.repositories.RestaurantTableRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class SearchService(
    private val userReposry: DinerRepository,
    private val restaurantService: RestaurantService,
    private val restaurantTableRepository: RestaurantTableRepository,
    private val reservationService: ReservationService,
    private val restaurantRepository: RestaurantRepository
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
    fun matchRestaurantEndorsements(users: List<String>, resStartTime: String): MutableSet<Restaurant> {
        val userRestrictions = getUserRestrictions(users) // get a set of the user groups restrictions
        val restaurants = ArrayList<Restaurant>() // create an empty arraylist of restaurants
        val allRestaurants = restaurantService.findAll() // get all restaurants from the database

        for (restaurant in allRestaurants) {
            if (restaurant.dietaryEndorsements.containsAll(userRestrictions)) {
                restaurants.add(restaurant)
            }
        }
        val allTables = findAllTables(restaurants.map { it.uuid })
        val allBookedTables =  findAllBookedTables(restaurants.map { it.uuid }, resStartTime)

        val availableTables = allTables.filterNot { tableUuid -> allBookedTables.contains(tableUuid) }

        println("THESE ARE AVAILABLE TABLES: ${availableTables}")

        val recommendedRestaurants = restaurantRepository.getAvailableRestaurants(availableTables)

        println("THIS SHOULD HAVE RESULTS: ${recommendedRestaurants}")

        val allAvailableRestaurants = mutableSetOf<Restaurant>()

        for(restaurant in recommendedRestaurants) {
            val availableRestaurant = restaurantRepository.findById(restaurant).get()
            allAvailableRestaurants.add(availableRestaurant)
        }


        return allAvailableRestaurants
    }

    fun findAllTables(restaurantsUuids: List<String>): List<String> {
        return restaurantTableRepository.finAllRestaurantTables(restaurantsUuids)
    }

    fun findAllBookedTables(restaurantsUuids: List<String>, startTime: String): List<String> {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")

        val fStartTime = formatter.parse(startTime)

        val endTime = reservationService.getEndTime(fStartTime)

        val resStartTime = formatter.format(fStartTime)
        val resEndTime = formatter.format(endTime)

        println("resStartTime: $resStartTime")
        println("resEndTime: $resEndTime")

        return restaurantTableRepository.findAllBookedTables(restaurantsUuids, resStartTime, resEndTime)
    }


}