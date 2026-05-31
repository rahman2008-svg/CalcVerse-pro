package com.calcverse.pro   // ← Fixed

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.calcverse.pro.ui.SplashScreen          // ← Fixed
import com.calcverse.pro.ui.theme.CalcVerseTheme   // ← Fixed (থিমের নাম অনুমান করা হয়েছে)
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel8, sdk = [35])   // ← 35 করা হয়েছে
class GreetingScreenshotTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun greeting_screenshot() {
    composeTestRule.setContent { 
      CalcVerseTheme {     // ← থিমের নাম অনুসারে পরিবর্তন করুন
        SplashScreen {} 
      } 
    }

    composeTestRule.onRoot().captureRoboImage(
        filePath = "build/outputs/roborazzi/greeting.png"   // ← CI/CD এর জন্য ভালো পাথ
    )
  }
}
