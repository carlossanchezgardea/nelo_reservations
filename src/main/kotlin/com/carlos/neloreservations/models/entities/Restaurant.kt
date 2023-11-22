package com.carlos.neloreservations.models.entities

import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import jakarta.persistence.Entity
import kotlinx.serialization.Serializable
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.*

@Entity
class Restaurant(

    uuid: String,
    val name: String,

    createdAt: Date,
    updatedAt: Date?,

    @Serializable
    @JdbcTypeCode(SqlTypes.JSON)
    val dietaryEndorsements: ArrayList<DietaryRestrictionType>


    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt) {
}