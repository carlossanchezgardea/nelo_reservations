package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.lib.Utils.DateConverter
import com.carlos.neloreservations.models.entities.Reservation
import com.carlos.neloreservations.models.json.ReservationRequest
import com.carlos.neloreservations.services.ReservationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat


@RestController
@RequestMapping("/api")
class ReservationController(private val reservationService: ReservationService) {
    private val dateConverter = DateConverter()

//    @PostMapping("/reservation")
//    fun makeReservation(@RequestBody reservationRequest: ReservationRequest): ResponseEntity<Reservation> {
//
//
//        val resStartTime = dateConverter.formatTimeUtc(reservationRequest.startTime)
//        val restaurantUuid = reservationRequest.restaurantUuid
//
//        val reservation = reservationService.makeReservation(resStartTime, restaurantUuid)
//
//        return ResponseEntity.ok(reservation)
//
//    }

//    @PostMapping("/reservation")
//    fun getTables(): String? {
//        val time = "2023-12-25 18:00"
//        val restaurantUuid = "2bad3cc6-6562-4c61-bea2-0a863bf4da4b"
//        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
//
//        val resStartTime = formatter.parse(time)
//
//        return reservationService.getAvailableTable(resStartTime, restaurantUuid)
//    }

    @PostMapping("/reservation")
    fun makeReservation(@RequestBody reservationRequest: ReservationRequest): ResponseEntity<Reservation> {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val resStartTime = formatter.parse(reservationRequest.startTime)
        val restaurantUuid = reservationRequest.restaurantUuid
        val dinerUsers = reservationRequest.dinerUsers

        val reservation = reservationService.makeReservation(resStartTime, restaurantUuid, dinerUsers)

        return ResponseEntity.ok(reservation)
    }

    @DeleteMapping("/reservation/{userUuid}/{reservationUuid}")
    fun deleteReservation(@PathVariable userUuid: String, @PathVariable reservationUuid: String): ResponseEntity<String> {
        reservationService.cancelReservation(userUuid, reservationUuid)
        return ResponseEntity.ok("Reservation deleted")
    }

}