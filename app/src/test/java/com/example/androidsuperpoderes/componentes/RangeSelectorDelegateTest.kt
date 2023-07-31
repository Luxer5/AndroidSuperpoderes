package com.example.androidsuperpoderes.componentes

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class RangeSelectorDelegateTest{
    val rangeSelectorDelegate = RangeSelectorDelegate(40, 80)

    @Test
    fun `WHEN moveBottom EXPECT bottom is currentTop -1` (){
        rangeSelectorDelegate.moveBottom(90)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(79))
    }
}