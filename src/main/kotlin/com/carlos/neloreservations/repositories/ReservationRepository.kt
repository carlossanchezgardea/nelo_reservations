package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.Reservation
import org.springframework.data.repository.CrudRepository

interface ReservationRepository: CrudRepository<Reservation, String> {
}