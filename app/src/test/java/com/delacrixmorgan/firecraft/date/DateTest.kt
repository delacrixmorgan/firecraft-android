package com.delacrixmorgan.firecraft.date

import com.delacrixmorgan.firecraft.extension.getDaysTo
import com.delacrixmorgan.firecraft.extension.minusDays
import com.delacrixmorgan.firecraft.extension.plusDays
import com.delacrixmorgan.firecraft.extension.toDate
import com.delacrixmorgan.firecraft.extension.toLocalDateTime
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime
import java.util.Date

class DateTest {

    @Test
    fun `Given LocalTimeDate When converting to Date Then return same date`() {
        val stringDate = "2020-01-01T12:34:56Z"
        val javaDate = stringDate.toDate()

        val localDateTime = stringDate.toLocalDateTime()
        val convertedJavaDate = localDateTime?.toDate()

        Assert.assertEquals(
            "Should have zero days in between",
            javaDate?.getDaysTo(convertedJavaDate ?: Date()),
            0
        )
    }

    @Test
    fun `Given Date When converting to LocalDateTime Then return same date`() {
        val stringDate = "2020-01-01T12:34:56Z"
        val localDateTime = stringDate.toLocalDateTime()

        val javaDate = stringDate.toDate()
        val convertedLocalDateTime = javaDate?.toLocalDateTime()

        Assert.assertEquals(
            "Should have zero days in between",
            localDateTime?.getDaysTo(convertedLocalDateTime ?: LocalDateTime.now())?.toInt(),
            0
        )
    }

    @Test
    fun `Given date When plus 30 days Then should return correct date`() {
        val startDate = "2020-01-01T12:34:56Z".toDate()
        val expectedDate = "2020-01-31T12:34:56Z".toDate()

        val endDate = startDate?.plusDays(30)

        Assert.assertEquals(
            "Should be $expectedDate",
            expectedDate,
            endDate
        )
    }

    @Test
    fun `Given date When minus 30 days Then should return correct date`() {
        val startDate = "2020-01-31T12:34:56Z".toDate()
        val expectedDate = "2020-01-01T12:34:56Z".toDate()

        val endDate = startDate?.minusDays(30)

        Assert.assertEquals(
            "Should be $expectedDate",
            expectedDate,
            endDate
        )
    }
}