package com.example.androidsuperpoderes.presentation.login

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test

class LoginScreenTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testClickLoginButton(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgotPassword = {})
        }

        rule.onNodeWithTag(LOGIN_TEXT_FIELD_USER)
            .performTextInput("ejemplo@gmail.com")
        rule.onNodeWithTag(LOGIN_TEXT_FIELD_PASSWORD)
            .performTextInput("password")

        rule.onNodeWithText("Login").performClick()
        assertThat(logged, `is`(true))
    }

    @Test
    fun testFalsePassLoginutton(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgotPassword = {})
        }

        rule.onNodeWithTag(LOGIN_TEXT_FIELD_USER)
            .performTextInput("ejemplo@gmail.com")
        rule.onNodeWithTag(LOGIN_TEXT_FIELD_PASSWORD)
            .performTextInput("errorsito")

        rule.onNodeWithText("Login").performClick()
        assertThat(logged, `is`(false))
    }
    @Test
    fun testFalseUserLoginutton(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgotPassword = {})
        }

        rule.onNodeWithTag(LOGIN_TEXT_FIELD_USER)
            .performTextInput("emailsito")
        rule.onNodeWithTag(LOGIN_TEXT_FIELD_PASSWORD)
            .performTextInput("password")

        rule.onNodeWithText("Login").performClick()
        assertThat(logged, `is`(false))
    }
    @Test
    fun testFalse3Loginutton(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgotPassword = {})
        }

        rule.onNodeWithTag(LOGIN_TEXT_FIELD_USER)
            .performTextInput("emailsito")
        rule.onNodeWithTag(LOGIN_TEXT_FIELD_PASSWORD)
            .performTextInput("errorsito")

        rule.onNodeWithText("Login").performClick()
        assertThat(logged, `is`(false))
    }
}