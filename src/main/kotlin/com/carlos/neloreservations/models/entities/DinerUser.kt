package com.carlos.neloreservations.models.entities

import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import jakarta.persistence.Entity
import kotlinx.serialization.Serializable
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.*


@Entity
class DinerUser (
    uuid: String,

    val firstName: String,
    val lastName: String,

    createdAt: Date,

    updatedAt: Date? = null,

    @Serializable
    @JdbcTypeCode(SqlTypes.JSON)
    val dietaryRestrictions: ArrayList<DietaryRestrictionType>

    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt)

{

}
