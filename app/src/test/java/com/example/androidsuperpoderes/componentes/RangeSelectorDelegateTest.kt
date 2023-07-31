package com.example.androidsuperpoderes.componentes

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class RangeSelectorDelegateTest{
    val rangeSelectorDelegate = RangeSelectorDelegate(40, 80)

    @Test
    fun `WHEN moveBottom higger currentTop EXPECT  bottom = currenttop-1` (){
        rangeSelectorDelegate.moveBottom(90)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(79))
    }
    @Test
    fun `WHEN moveBottom lower than currentBottom EXPECT bottom is  minValue` (){
        rangeSelectorDelegate.moveBottom(30)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(40))
    }
    @Test
    fun `WHEN moveBottom bottom is higher than bottom and lower than top EXPECT bottom is current bottom` (){
        rangeSelectorDelegate.moveBottom(60)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(60))
    }
    @Test
    fun `WHEN moveTop higger currentTop EXPECT  top = maxTop` (){
        rangeSelectorDelegate.moveTop(90)
        assertThat(rangeSelectorDelegate.currentTop, `is`(80))
    }
    @Test
    fun `WHEN moveTop lower than currentBottom EXPECT top is currrentTop +1` (){
        rangeSelectorDelegate.moveTop(30)
        assertThat(rangeSelectorDelegate.currentTop, `is`(41))
    }
    @Test
    fun `WHEN moveTop bottom is higher than bottom and lowe than top EXPECT bottom is current bottom` (){
        rangeSelectorDelegate.moveTop(60)
        assertThat(rangeSelectorDelegate.currentTop, `is`(60))
    }

}