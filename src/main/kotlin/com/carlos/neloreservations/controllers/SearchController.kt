package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.services.SearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/restaurant/search")
class SearchController(private val searchService: SearchService) {

    @GetMapping("/test")
    fun test(): ResponseEntity<ArrayList<Restaurant>>{
        val testResponse = searchService.matchRestaurantEndorsements(arrayListOf("40b543be-e5c2-45de-ac6f-368db7de1638", "d755207b-c1cc-4af5-9fa2-0a545899f3da"))
        return ResponseEntity.ok().body(testResponse)
    }

    @GetMapping("/search")
    fun search(@RequestParam("uuids") uuids: List<String>): ResponseEntity<ArrayList<Restaurant>> {
        val testResponse = searchService.matchRestaurantEndorsements(uuids)
        return ResponseEntity.ok().body(testResponse)
    }

    //TODO: you can now filter by dietary restrictions,
    //TODO!!: but you need to implement the logic to also check table and user availability!!
    //TODO!!!: you also need to implement the logic to check if the restaurant is open at the time of the reservation!! FUCK!!
}