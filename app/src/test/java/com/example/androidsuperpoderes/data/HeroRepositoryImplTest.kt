package com.example.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidsuperpoderes.data.dto.HeroDTO
import com.example.androidsuperpoderes.data.local.LocalDataSource
import com.example.androidsuperpoderes.data.local.model.HeroLocal
import com.example.androidsuperpoderes.data.remote.RemoteDataSource
import com.example.androidsuperpoderes.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HeroRepositoryImplTest(){
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getHeroLisy EXPECT local data`() = runTest{
        coEvery { localDataSource.getHeroList() } returns getListHeroLocalo()
        coEvery { remoteDataSource.getHeroList() } returns listOf()

        val repo = HeroRepositoryImpl(remoteDataSource, localDataSource)

        val res = repo.getHeroList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
    @Test
    fun `WHEN getHeroLisy EXPECT remote data`() = runTest{
        coEvery { localDataSource.getHeroList() } returns listOf()
        coEvery { remoteDataSource.getHeroList() } returns getListRemote()

        val repo = HeroRepositoryImpl(remoteDataSource, localDataSource)

        val res = repo.getHeroList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }


}

fun getListHeroLocalo() = listOf(HeroLocal("id","name","url",false,""),
    HeroLocal("","","",false,""))

fun getListRemote() = listOf<HeroDTO>(
    HeroDTO("id", "name", "url", "description", true),
    HeroDTO("id", "name", "url", "description", true)
)