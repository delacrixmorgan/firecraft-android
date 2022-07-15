package com.delacrixmorgan.firecraft.extension

import android.text.format.DateUtils
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import kotlin.math.roundToInt

fun LocalDateTime.toDate(): Date = Date.from(
    this.atZone(ZoneId.systemDefault())
        .toInstant()
)

fun Date.toLocalDateTime(): LocalDateTime = LocalDateTime.ofInstant(
    this.toInstant(),
    ZoneOffset.UTC
)

fun String.toDate(): Date? {
    val dateInstant = Instant.from(DateTimeFormatter.ISO_INSTANT.parse(this))
    return Date.from(dateInstant)
}

fun Date.getDaysTo(to: Date = Date()): Int {
    return ((to.time - this.time) / DateUtils.DAY_IN_MILLIS.toDouble()).roundToInt()
}

fun Date.plusDays(days: Int): Date {
    val calendar = Calendar.getInstance().apply {
        time = this@plusDays
    }

    calendar.add(Calendar.DATE, days)
    return calendar.time
}

fun Date.minusDays(days: Int): Date {
    val calendar = Calendar.getInstance().apply {
        time = this@minusDays
    }

    calendar.add(Calendar.DATE, -days)
    return calendar.time
}