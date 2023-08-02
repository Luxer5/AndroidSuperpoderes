package com.example.androidsuperpoderes.presentation.list

import ShowHeroList
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.androidsuperpoderes.domain.TestDataBuilder
import org.junit.Rule
import org.junit.Test

class ShowHeroTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testShowHero(){
        rule.setContent {
            ShowHeroList(
                TestDataBuilder()
                    .withName("Sample")
                    .buildSingle()
            ){}
        }

        rule.onNode(
            hasText
                ("Sample") and
                  hasClickAction()
        ).assertHasClickAction()
    }
}