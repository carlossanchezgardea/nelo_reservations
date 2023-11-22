package com.carlos.neloreservations.models.entities

import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import jakarta.persistence.*
import java.util.*

@Entity
class DietaryRestrictions (
    uuid: String,

    @ManyToOne
    @JoinColumn(name = "diner_user_uuid", referencedColumnName = "uuid")
    var dinerUser: DinerUser,

    @Enumerated(EnumType.STRING)
    var restriction: DietaryRestrictionType,

    createdAt: Date,
    updatedAt: Date?,

    ): BaseEntity(uuid = uuid,createdAt=createdAt, updatedAt=updatedAt ){

}