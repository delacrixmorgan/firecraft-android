package com.delacrixmorgan.firecraft.extension

import java.util.*

/**
 * Add and Remove days, hours or minutes in Date
 */
fun Date.addDaysToDate(days: Int): Date {
    val hoursInDay = 24
    return this.addHoursToDate(days * hoursInDay)
}

fun Date.addHoursToDate(hours: Int): Date {
    val minutesInHour = 60
    return this.addMinutesToDate(hours * minutesInHour)
}

fun Date.addMinutesToDate(minutes: Int): Date {
    val millisecondsInMinute: Long = 60_000
    val currentTimeInMilliseconds: Long = this.time
    return Date(currentTimeInMilliseconds + minutes * millisecondsInMinute)
}

fun Date.minusDaysToDate(days: Int): Date {
    val hoursInDay = 24
    return this.minusHoursToDate(days * hoursInDay)
}

fun Date.minusHoursToDate(hours: Int): Date {
    val minutesInHour = 60
    return this.minusMinutesToDate(hours * minutesInHour)
}

fun Date.minusMinutesToDate(minutes: Int): Date {
    val millisecondsInMinute: Long = 60_000
    val curTimeInMs: Long = this.time
    return Date(curTimeInMs - minutes * millisecondsInMinute)
}