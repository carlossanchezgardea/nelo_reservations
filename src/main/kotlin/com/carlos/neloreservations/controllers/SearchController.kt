package com.carlos.neloreservations.controllers

import com.carlos.neloreservations.lib.Utils.DateConverter
import com.carlos.neloreservations.models.entities.Restaurant
import com.carlos.neloreservations.services.SearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/restaurant")
class SearchController(private val searchService: SearchService) {
    private val dateConverter = DateConverter()

    //    @GetMapping("/search")
//    fun search(@RequestParam("uuids") uuids: List<String>): ResponseEntity<ArrayList<Restaurant>> {
//        val testResponse = searchService.matchRestaurantEndorsements(uuids)
//        return ResponseEntity.ok().body(testResponse)
//    }

    @GetMapping("/search")
    fun search(
        @RequestParam("uuids") uuids: List<String>,
        @RequestParam("date") startTime: String,
    ): ResponseEntity<MutableSet<Restaurant>> {

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val resStartTime = formatter.parse(startTime)

        val testResponse = searchService.matchRestaurantEndorsements(uuids, startTime)

        return ResponseEntity.ok().body(testResponse)

    }


}