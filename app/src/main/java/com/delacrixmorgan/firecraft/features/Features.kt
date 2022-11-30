package com.delacrixmorgan.firecraft.features

import androidx.fragment.app.Fragment
import com.delacrixmorgan.firecraft.features.hapticfeedback.HapticFeedbackFragment
import com.delacrixmorgan.firecraft.features.locale.LocaleFragment
import com.delacrixmorgan.firecraft.features.notification.NotificationFragment
import com.delacrixmorgan.firecraft.features.screenshot.ScreenshotFragment

enum class Features(
    val featureName: String,
    val fragmentBuilder: () -> Fragment
) {
    Notification(
        featureName = "Notification",
        fragmentBuilder = { NotificationFragment.create() }
    ),
    Screenshot(
        featureName = "Screenshot",
        fragmentBuilder = { ScreenshotFragment.create() }
    ),
    HapticFeedback(
        featureName = "Haptic Feedback",
        fragmentBuilder = { HapticFeedbackFragment.create() }
    ),
    Locale(
        featureName = "Locale",
        fragmentBuilder = { LocaleFragment.create() }
    )
}