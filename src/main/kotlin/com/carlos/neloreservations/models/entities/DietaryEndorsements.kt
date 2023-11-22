package com.carlos.neloreservations.models.entities

import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import jakarta.persistence.*
import java.util.*

@Entity
class DietaryEndorsements(

    uuid: String,

    @ManyToOne
    @JoinColumn(name = "restaurant_uuid", referencedColumnName = "uuid")
    var restaurant: Restaurant,

    @Enumerated(EnumType.STRING)
    var endorsement: DietaryRestrictionType,

    createdAt: Date,
    updatedAt: Date?,

    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt) {

    }