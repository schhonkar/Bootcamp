package com.example.testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Espress UI Testing for checkButton
 */
@RunWith(AndroidJUnit4::class)
class IsFavouriteAdded {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)


    /**
     * To run this test please uncomment the code on line no.16 in Main Activity
     */
//    @Test
//    fun addToFav_checkBoxIsNotChecked(){
//        onView(withId(R.id.button))
//            .perform(click())
//        onView(withId(R.id.checkBox))
//            .check(matches(isNotChecked()))
//    }

    /**
     * To check if the button is working properly
     */
    @Test
    fun addToFav_checkBoxIsChecked(){
        onView(withId(R.id.button))
            .perform(click())
        onView(withId(R.id.checkBox))
            .check(matches(isChecked()))
    }




}