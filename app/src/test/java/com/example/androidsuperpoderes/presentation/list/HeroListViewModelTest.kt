package com.example.androidsuperpoderes.presentation.list


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.domain.useCase.GetDetailUseCase
import com.example.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import com.example.androidsuperpoderes.presentation.detail.DetailViewModel
import com.example.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.example.androidsuperpoderes.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.hamcrest.MatcherAssert.assertThat


@OptIn(ExperimentalCoroutinesApi::class)
class HeroListViewModelTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    //Sirve apra que el caso de uso se ejecute como nosotros queremos sin llamar al repository ni nada
    @MockK(relaxed = true)
    private lateinit var getHeroListUseCase: GetHeroListUseCase
    @MockK(relaxed = true)
    private lateinit var getDetailUseCase: GetDetailUseCase



    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }
    @After
    fun tearDown(){
        //Liberar recursos del test
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
        coEvery { getHeroListUseCase.invoke() } returns TestDataBuilder()
            .withNumElements(15)
            .buildList()

        val viewModel = HeroListViewModel(getHeroListUseCase)

        val res = viewModel.heroList.getOrAwaitValue()
        assertThat(res.size,`is`(15))
    }

    @Test
    fun `WHEN detailViewModel init EXPECT data at detailLiveData`() = runTest {
        coEvery { getDetailUseCase.invoke("test-id") } returns TestDataBuilder()
            .buildSingle()

        val viewModel = DetailViewModel(getDetailUseCase)
        viewModel.getData("test-id")

        val res = viewModel.hero.getOrAwaitValue()
        assertThat(res.id, `is`("test-id"))
    }

}