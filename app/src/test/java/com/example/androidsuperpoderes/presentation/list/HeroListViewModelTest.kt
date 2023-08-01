package com.example.androidsuperpoderes.presentation.list


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidsuperpoderes.testutil.DefaultDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class HeroListViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @Test
    fun testCourutinesTest() = runTest {
        val test = true

        assertTrue(test)
    }
}