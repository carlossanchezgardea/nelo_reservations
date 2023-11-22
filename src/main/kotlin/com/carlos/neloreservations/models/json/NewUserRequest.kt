package com.carlos.neloreservations.models.json

import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import java.util.*

data class NewUserRequest(
    val uuid: String = "",
    val createdAt: Date?,
    val firstName: String,
    val lastName: String,
    val dietaryRestriction: ArrayList<DietaryRestrictionType>
)
