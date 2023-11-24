package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.UserReservation
import org.springframework.data.repository.CrudRepository

interface UserReservationRepository: CrudRepository<UserReservation, String> {

}