package com.example.architectureexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.architectureexample.presentation.ui.crypto_list.adapter.CryptoListAdapter
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel
import com.example.architectureexample.presentation.ui.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CryptoListFragmentTest {
    @get : Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun testCryptoInfoOpenedAfterClickOnCryptoItemInRecycler() {
        onView(ViewMatchers.withId(R.id.crypto_info_root)).check(doesNotExist())
        onView(ViewMatchers.withId(R.id.rvCryptoList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<CryptoListAdapter.CryptoViewHolder>(
                0,
                click()
            )
        )
        onView(ViewMatchers.withId(R.id.crypto_info_root)).check(matches(isDisplayed()))
    }
}