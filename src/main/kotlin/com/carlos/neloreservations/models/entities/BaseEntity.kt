package com.carlos.neloreservations.models.entities

import com.carlos.neloreservations.lib.SqlType.CHAR_36
import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PreUpdate
import org.hibernate.annotations.CreationTimestamp
import java.util.*

@MappedSuperclass
abstract class BaseEntity (
    @Id
    @Column(nullable = false, columnDefinition = CHAR_36)
    val uuid: String = UUID.randomUUID().toString(),

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: Date = Date(),

    var updatedAt: Date? = null,
){
    @PreUpdate
    private fun setLastUpdate() {
        this.updatedAt = Date()
    }
}