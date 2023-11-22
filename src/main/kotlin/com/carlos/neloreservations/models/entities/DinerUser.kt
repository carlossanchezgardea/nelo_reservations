package com.carlos.neloreservations.models.entities

import com.carlos.neloreservations.models.enums.DietaryRestrictions
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.util.*


@Entity
class DinerUser (
    uuid: String,

    val firstName: String,
    val lastName: String,


    @Column(columnDefinition = "jsonb")
    var dietaryRestrictions: MutableList<DietaryRestrictions>,

    createdAt: Date,
    updatedAt: Date?,

    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt)
{

}