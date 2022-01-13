package com.delacrixmorgan.firecraft

import com.delacrixmorgan.firecraft.extension.addDaysToDate
import com.delacrixmorgan.firecraft.extension.minusDaysToDate
import org.junit.Assert
import org.junit.Test
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

class DateTest {
    @Test
    fun `Add days to date and compare with expected date`() {
        val startDate = createDateTime("2020-01-01T00:00:00.000Z")
        val expectedDate = createDateTime("2020-01-31T00:00:00.000Z")

        val endDate = startDate.addDaysToDate(days = 30)
        Assert.assertEquals(
            "Should be $expectedDate",
            expectedDate,
            endDate
        )
    }

    @Test
    fun `Minus days to date and compare with expected date`() {
        val startDate = createDateTime("2020-01-31T00:00:00.000Z")
        val expectedDate = createDateTime("2020-01-01T00:00:00.000Z")

        val endDate = startDate.minusDaysToDate(days = 30)
        Assert.assertEquals(
            "Should be $expectedDate",
            expectedDate,
            endDate
        )
    }

    private fun createDateTime(dateString: String): Date {
        val dateInstant = Instant.from(DateTimeFormatter.ISO_INSTANT.parse(dateString))
        return Date.from(dateInstant)
    }
}