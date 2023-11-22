package com.carlos.neloreservations.repositories

import com.carlos.neloreservations.models.entities.DinerUser

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DinerRepository: CrudRepository<DinerUser, String> {

}