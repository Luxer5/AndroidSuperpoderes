package com.example.androidsuperpoderes.ext

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StringExtKtTest{
    @Test
    fun `WHEN creates heroModel EXPECT photoUrl contains schema`(){
        val testUrl = "https://some-domain.com"
        val res = testUrl.hasHtttps()
        assertThat(res, `is`(true))
    }
}