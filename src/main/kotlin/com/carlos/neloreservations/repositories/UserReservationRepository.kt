package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.UserReservation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserReservationRepository: CrudRepository<UserReservation, String> {

    @Query(
        value = """
        SELECT DISTINCT case when ur.reservation_uuid is null then false else true end as is_reserved
        FROM user_reservation ur
        LEFT JOIN reservation r ON r.uuid = ur.reservation_uuid
        WHERE ur.diner_user_uuid = :userUuid
        AND r.deleted_at IS NULL
        AND ur.reservation_uuid = :reservationUuid
        and ur.diner_user_uuid = :userUuid
        """,
        nativeQuery = true
    )
    fun checkUserToReservation(
        @Param("userUuid") userUuid: String,
        @Param("reservationUuid") reservationUuid: String
    ): Boolean
}