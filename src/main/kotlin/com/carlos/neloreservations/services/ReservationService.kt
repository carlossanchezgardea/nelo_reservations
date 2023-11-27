package com.carlos.neloreservations.services

import com.carlos.neloreservations.lib.Utils.DateConverter
import com.carlos.neloreservations.models.entities.Reservation
import com.carlos.neloreservations.models.entities.UserReservation
import com.carlos.neloreservations.repositories.DinerRepository
import com.carlos.neloreservations.repositories.ReservationRepository
import com.carlos.neloreservations.repositories.RestaurantTableRepository
import com.carlos.neloreservations.repositories.UserReservationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.text.SimpleDateFormat
import java.util.*

@Service
class ReservationService(
    private val reservationRepository: ReservationRepository,
    private val restaurantTableRepository: RestaurantTableRepository,
    private val dinerRepository: DinerRepository,
    private val userReservationRepository: UserReservationRepository
) {

    private val dateConverter = DateConverter()
    fun save(reservation: Reservation): Reservation {
        return reservationRepository.save(reservation)
    }

    fun getEndTime(startTime: Date): Date {

        val calendar = Calendar.getInstance()

        calendar.time = startTime // this sets the calendar to the date
        calendar.add(Calendar.MINUTE, 120) // this adds 120 minutes to the calendar

        val resEndTime = calendar.time // this returns the date with the 90 minutes added

        return resEndTime
    }

    //get all tables from the restaurant where we want to make the reservation
    fun getAllRestaurantTables(restaurantUuid: String): List<String> {
        return restaurantTableRepository.findTableUuidsByRestaurant(restaurantUuid)
    }

    // get all available tables for a given time and pick one
    fun getAvailableTable(startTime: Date, restaurantUuid: String): String? {
        val listOfTables = getAllRestaurantTables(restaurantUuid)

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val endFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val resStartTime = formatter.format(startTime)
        val endTime = getEndTime(startTime)
        val resEndTime = endFormatter.format(endTime)
        val reservedTable =
            restaurantTableRepository.findOverlappingReservations(restaurantUuid, resStartTime, resEndTime)
        val availableTables = listOfTables.filterNot { it in reservedTable }

        return availableTables[0]

    }

    // make a reservation
    @Transactional
    fun makeReservation(startTime: Date, restaurantUuid: String, dinnerUsers: List<String>): Reservation {

        val resEndTime = getEndTime(startTime)


        val availableTable = getAvailableTable(startTime, restaurantUuid)

        val table = restaurantTableRepository.findById(availableTable!!)

        val reservation = Reservation(
            uuid = UUID.randomUUID().toString(),
            startTime = startTime,
            endTime = resEndTime,
            restaurantTable = table.get(),
            createdAt = Date()
        )

        val confirmedReservation: Reservation = reservationRepository.save(reservation)

        for (diner in dinnerUsers) {
            val dinerUser = dinerRepository.findById(diner)
            val userReservation = UserReservation(
                uuid = UUID.randomUUID().toString(),
                dinerUser = dinerUser.get(),
                reservation = confirmedReservation,
                createdAt = Date()
            )
            userReservationRepository.save(userReservation)
        }
        return confirmedReservation
    }


    fun cancelReservation(userUuid: String, reservationUuid: String): Unit {

        val userReservation = userReservationRepository.checkUserToReservation(userUuid, reservationUuid)
        println("userReservation: $userReservation")

        if(!userReservation){
            throw Exception("User is not part of this reservation")
        }

        var reservationToCancel = reservationRepository.findById(reservationUuid).get()

        reservationToCancel.deletedAt = Date()

        reservationRepository.save(reservationToCancel)


    }
}