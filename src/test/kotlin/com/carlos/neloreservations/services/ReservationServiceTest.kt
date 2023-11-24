package com.carlos.neloreservations.services

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private lateinit var reservationService: ReservationService

    @Test
    fun `getAvailableTable should return a available table`(){
        // given


        val startTime = Date()
        val restaurantUuid = "1234"



        //when
        val resp = reservationService.getAvailableTable(startTime, restaurantUuid)

        // then
        assertEquals("5678", resp)
    }

}