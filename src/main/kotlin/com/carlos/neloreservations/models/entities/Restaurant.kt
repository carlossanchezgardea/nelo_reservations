package com.carlos.neloreservations.models.entities

import jakarta.persistence.Entity
import java.util.*

@Entity
class Restaurant(

    uuid: String,
    val name: String,

    createdAt: Date,
    updatedAt: Date?,

    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt) {
}