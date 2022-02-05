package com.delacrixmorgan.firecraft.extension

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters
import kotlin.math.abs

object DateFormat {
    const val ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
}

object DateConstant {
    const val ONE_DAY_IN_MS: Long = 86_400_000
}

fun LocalDateTime.format(pattern: String? = DateFormat.ISO_8601): String? = try {
    DateTimeFormatter.ofPattern(pattern).format(this)
} catch (exception: Exception) {
    null
}

fun String.toLocalDateTime(pattern: String? = DateFormat.ISO_8601): LocalDateTime? = try {
    LocalDateTime.parse(this@toLocalDateTime, DateTimeFormatter.ofPattern(pattern))
} catch (exception: Exception) {
    null
}

fun LocalDateTime.getDaysTo(to: LocalDateTime?): Long =
    ChronoUnit.DAYS.between(this, to)

fun LocalDateTime.getDaysBetween(to: LocalDateTime?): Long =
    abs(ChronoUnit.DAYS.between(this, to))

fun LocalDateTime.nextDayOfTheWeek(dayOfWeek: DayOfWeek): LocalDateTime =
    this.plusHours(1)
        .with(TemporalAdjusters.next(dayOfWeek))
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()