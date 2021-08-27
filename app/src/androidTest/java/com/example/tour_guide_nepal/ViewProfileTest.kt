package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.ViewPagerActions.scrollLeft
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@LargeTest
@RunWith(JUnit4::class)

class ViewProfileTest {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)
    fun customswipeLeft(): ViewAction? {
        return GeneralSwipeAction(
            Swipe.FAST,
            GeneralLocation.CENTER_RIGHT,
            GeneralLocation.CENTER_LEFT,
            Press.FINGER
        )
    }
    @Test
    fun viewProfileTest() {
        Espresso.onView(withId(R.id.welcomelayout))
            .check(matches(isDisplayed()))
            .perform(customswipeLeft());
        Espresso.onView(withId(R.id.etfullname))
            .check(matches(isDisplayed()))


    }
}