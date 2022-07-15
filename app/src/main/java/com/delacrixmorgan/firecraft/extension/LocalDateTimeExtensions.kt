package com.delacrixmorgan.firecraft.extension

import android.text.format.DateUtils
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

fun String.toLocalDateTime(pattern: String = DateFormat.ISO_8601): LocalDateTime? = try {
    LocalDateTime.parse(this, DateTimeFormatter.ofPattern(pattern))
} catch (exception: Exception) {
    null
}

fun LocalDateTime.format(pattern: String = DateFormat.ISO_8601): String? = try {
    DateTimeFormatter.ofPattern(pattern).format(this)
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

fun LocalDateTime.getRelativeTimeSpanString(now: LocalDateTime?): CharSequence? =
    DateUtils.getRelativeTimeSpanString(
        getEpochMilli(),
        (now ?: LocalDateTime.now()).getEpochMilli(),
        DateUtils.MINUTE_IN_MILLIS,
        DateUtils.FORMAT_ABBREV_TIME
    )

fun LocalDateTime.getEpochMilli(): Long =
    atZone(ZoneId.systemDefault())
        .toInstant()
        .toEpochMilli()