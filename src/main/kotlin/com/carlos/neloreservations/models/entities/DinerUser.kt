package com.carlos.neloreservations.models.entities

import jakarta.persistence.Entity
import java.util.*


@Entity
class DinerUser (
    uuid: String,

    val firstName: String,
    val lastName: String,

    createdAt: Date,
    updatedAt: Date?,

    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt)
{

}