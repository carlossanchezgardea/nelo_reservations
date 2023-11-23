package com.carlos.neloreservations.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
class Reservation(

    uuid: String = UUID.randomUUID().toString(),

    @ManyToOne
    @JoinColumn(name = "restaurant_table_uuid")
    val restaurantTable: RestaurantTable,

    val startTime: Date,
    val endTime: Date,

    val deletedAt: Date? = null,




    createdAt: Date,
    updatedAt: Date? = null,

    ) : BaseEntity(uuid = uuid, createdAt = createdAt, updatedAt = updatedAt){

}