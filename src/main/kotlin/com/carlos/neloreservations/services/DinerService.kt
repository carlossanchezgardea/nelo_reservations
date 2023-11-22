package com.carlos.neloreservations.services

import com.carlos.neloreservations.models.entities.DinerUser
import com.carlos.neloreservations.models.enums.DietaryRestrictionType
import com.carlos.neloreservations.repositories.DinerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DinerService(private val dinerRepository: DinerRepository) {

    fun findById(uuid: String): DinerUser {
        val optionalDinner: Optional<DinerUser> = dinerRepository.findById(uuid)
        if (optionalDinner.isPresent) {
            return optionalDinner.orElse(null)
        } else {
            throw Exception("Diner with id $uuid does not exists")
        }
    }

    fun getOneRestriction(uuid: String):
            ArrayList<DietaryRestrictionType> {
        val optionalDinner: Optional<DinerUser> = dinerRepository.findById(uuid)
        if (optionalDinner.isPresent) {
            return optionalDinner.get().dietaryRestrictions
        } else {
            throw Exception("Diner with id $uuid does not exists")
        }
    }

    fun findAll(): MutableIterable<DinerUser> {
        return dinerRepository.findAll()
    }

    fun createDiner(firstName: String, lastName: String, dietaryRestrictions: ArrayList<DietaryRestrictionType>): DinerUser {
        val diner = DinerUser(
            uuid = UUID.randomUUID().toString(),
            firstName = firstName,
            lastName = lastName,
            createdAt = Date(),
            dietaryRestrictions = dietaryRestrictions
        )
        return dinerRepository.save(diner)
    }
}