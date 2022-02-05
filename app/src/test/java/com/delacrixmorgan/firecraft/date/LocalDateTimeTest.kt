package com.delacrixmorgan.firecraft.date

import com.delacrixmorgan.firecraft.extension.format
import com.delacrixmorgan.firecraft.extension.getDaysBetween
import com.delacrixmorgan.firecraft.extension.getDaysTo
import com.delacrixmorgan.firecraft.extension.nextDayOfTheWeek
import com.delacrixmorgan.firecraft.extension.toLocalDateTime
import org.junit.Assert
import org.junit.Test
import java.time.DayOfWeek

class LocalDateTimeTest {

    @Test
    fun `Given date with ISO 8601 string when converting to LocalDateTime Then return same date`() {
        val iso8601String = "2020-01-01T12:34:56Z"
        val localDateTime = iso8601String.toLocalDateTime()
        val convertedDateString = localDateTime?.format()

        Assert.assertEquals(iso8601String, convertedDateString)
    }

    @Test
    fun `Given date When plus 30 days Then should return correct date`() {
        val startDate = "2020-01-01T12:34:56Z".toLocalDateTime()
        val expectedDate = "2020-01-31T12:34:56Z".toLocalDateTime()

        val endDate = startDate?.plusDays(30)

        Assert.assertEquals(
            "Should be $expectedDate",
            expectedDate,
            endDate
        )
    }

    @Test
    fun `Given date When minus 30 days Then should return correct date`() {
        val startDate = "2020-01-31T12:34:56Z".toLocalDateTime()
        val expectedDate = "2020-01-01T12:34:56Z".toLocalDateTime()

        val endDate = startDate?.minusDays(30)

        Assert.assertEquals(
            "Should be $expectedDate",
            expectedDate,
            endDate
        )
    }

    @Test
    fun `Given date and date after 30 days When comparing days apart using getDaysTo Then should return 30 days`() {
        val startDate = "2020-01-01T12:34:56Z".toLocalDateTime()
        val endDate = "2020-01-31T12:34:56Z".toLocalDateTime()

        val expectedDifferenceInDays = 30
        val differenceInDays = startDate?.getDaysTo(endDate)?.toInt()

        Assert.assertEquals(
            "Should be $expectedDifferenceInDays",
            expectedDifferenceInDays,
            differenceInDays
        )
    }

    @Test
    fun `Given date and date after 30 days When comparing days apart using getDaysBetween Then should return 30 days`() {
        val startDate = "2020-01-01T12:34:56Z".toLocalDateTime()
        val endDate = "2020-01-31T12:34:56Z".toLocalDateTime()

        val expectedDifferenceInDays = 30
        val differenceInDays = endDate?.getDaysBetween(startDate)?.toInt()

        Assert.assertEquals(
            "Should be $expectedDifferenceInDays",
            expectedDifferenceInDays,
            differenceInDays
        )
    }

    @Test
    fun `Given date When find next Day of the Week Then should return correct date`() {
        val startDate = "2022-01-01T12:34:56Z".toLocalDateTime()

        Assert.assertEquals(
            "Should be DayOfWeek.SUNDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.SUNDAY)?.dayOfWeek,
            "2022-01-02T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )

        Assert.assertEquals(
            "Should be DayOfWeek.MONDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.MONDAY)?.dayOfWeek,
            "2022-01-03T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )

        Assert.assertEquals(
            "Should be DayOfWeek.TUESDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.TUESDAY)?.dayOfWeek,
            "2022-01-04T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )

        Assert.assertEquals(
            "Should be DayOfWeek.WEDNESDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.WEDNESDAY)?.dayOfWeek,
            "2022-01-05T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )

        Assert.assertEquals(
            "Should be DayOfWeek.THURSDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.THURSDAY)?.dayOfWeek,
            "2022-01-06T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )

        Assert.assertEquals(
            "Should be DayOfWeek.FRIDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.FRIDAY)?.dayOfWeek,
            "2022-01-07T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )

        Assert.assertEquals(
            "Should be DayOfWeek.SATURDAY",
            startDate?.nextDayOfTheWeek(DayOfWeek.SATURDAY)?.dayOfWeek,
            "2022-01-08T12:34:56Z".toLocalDateTime()?.dayOfWeek
        )
    }
}