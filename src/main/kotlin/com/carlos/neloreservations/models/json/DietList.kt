package com.carlos.neloreservations.models.json

import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import java.io.Serializable

data class DietList(
    val restrictions: List<DietaryRestrictionType> = listOf()
): Serializable

