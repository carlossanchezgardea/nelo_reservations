package com.carlos.neloreservations.models.json

data class ReservationRequest(
    val restaurantUuid: String,
    val startTime: String
)
