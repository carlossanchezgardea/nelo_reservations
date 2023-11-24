package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.RestaurantTable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface RestaurantTableRepository : CrudRepository<RestaurantTable, String> {

    @Query(
        value = "SELECT rt.uuid FROM restaurant_table rt WHERE rt.restaurant_uuid = :restaurantUuid",
        nativeQuery = true
    )
    fun findTableUuidsByRestaurant(@Param("restaurantUuid") restaurantUuid: String): List<String>


    @Query(
        value = """
    SELECT rt.uuid AS restaurant_table_uuid
    FROM reservation rs
    JOIN restaurant_table rt ON rt.uuid = rs.restaurant_table_uuid
    WHERE rt.restaurant_uuid = :restaurantUuid
      AND rs.deleted_at IS NULL
      AND (CAST(:startTime AS timestamp) BETWEEN rs.start_time AND rs.end_time
            OR CAST(:endTime AS timestamp) BETWEEN rs.start_time AND rs.end_time)
    """,
        nativeQuery = true
    )
    fun findOverlappingReservations(
        @Param("restaurantUuid") restaurantUuid: String,
        @Param("startTime") startTime: String,
        @Param("endTime") endTime: String
    ): List<String>

}

