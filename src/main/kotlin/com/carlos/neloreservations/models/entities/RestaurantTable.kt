package com.carlos.neloreservations.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
class RestaurantTable (

    uuid: String = UUID.randomUUID().toString(),
    val capacity: Int,

    createdAt: Date,
    updatedAt: Date? = null,

    @ManyToOne
    @JoinColumn(name = "restaurant_uuid")
    val restaurant: Restaurant,

    ): BaseEntity(uuid=uuid, createdAt=createdAt, updatedAt=updatedAt){

}