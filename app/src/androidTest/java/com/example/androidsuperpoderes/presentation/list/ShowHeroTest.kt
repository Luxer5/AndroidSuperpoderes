package com.example.androidsuperpoderes.presentation.list

import ShowHero
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.androidsuperpoderes.domain.TestDataBuilder
import org.junit.Rule
import org.junit.Test

class ShowHeroTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testShowHero(){
        rule.setContent {
            ShowHero(
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