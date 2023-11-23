package com.carlos.neloreservations.models.json

import com.carlos.neloreservations.models.enums.DietaryRestrictionType

data class CreateRestaurantRequest(
    val name: String,
    val dietaryEndorsements: ArrayList<DietaryRestrictionType>

)


