package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.Restaurant
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository: CrudRepository<Restaurant, String> {
}