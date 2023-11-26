package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.Restaurant
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository: CrudRepository<Restaurant, String> {



    @Query(
        value = """
        SELECT DISTINCT r.uuid 
        FROM restaurant r
        LEFT JOIN restaurant_table rt ON rt.restaurant_uuid = r.uuid
        WHERE rt.uuid IN (:availableTables)
        """,
        nativeQuery = true
    )
    fun getAvailableRestaurants(
        @Param("availableTables") availableTables: List<String>
    ): List<String>
}