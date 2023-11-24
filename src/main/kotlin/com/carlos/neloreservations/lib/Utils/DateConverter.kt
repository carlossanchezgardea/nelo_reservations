package com.carlos.neloreservations.lib.Utils

import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    fun formatTimeUtc(time: String): Date {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        return formatter.parse(time)
    }
}