package com.carlos.neloreservations.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
class UserReservation(

    uuid: String = UUID.randomUUID().toString(),

    @ManyToOne
    @JoinColumn(name = "diner_user_uuid")
    val dinerUser: DinerUser,

    @ManyToOne
    @JoinColumn(name = "reservation_uuid")
    val reservation: Reservation,

    createdAt: Date,
    updatedAt: Date? = null,

): BaseEntity(uuid=uuid, createdAt = createdAt, updatedAt = updatedAt) {

}