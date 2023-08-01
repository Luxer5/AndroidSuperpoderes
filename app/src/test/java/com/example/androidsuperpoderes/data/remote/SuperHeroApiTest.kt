package com.example.androidsuperpoderes.data.remote

import IdDto
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidsuperpoderes.data.dto.SearchDto
import com.example.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class SuperHeroApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    private lateinit var api: SuperHeroApi

    @Before
    fun setup(){
        api = retrofit.create(SuperHeroApi::class.java)
    }


    @Test
    fun `WHEN request hero list EXPECT result`() = runTest {
        val result = api.getHeroList(SearchDto())
        assertThat(result.isNotEmpty(), `is`(true) )
    }
    @Test
    fun `WHEN request with search EXPECT item`() = runTest {
        val result = api.getHeroList(SearchDto("Goku"))
        assertThat(result.size, `is`(1) )
    }
    @Test
    fun `WHEN request with random text EXPECT empty list`() = runTest {
        val result = api.getHeroList(SearchDto("dfhdfhdfh"))
        assertThat(result.isEmpty(), `is`(true) )
    }
    @Test
    fun `WHEN request hero location EXPECT result`() = runTest {
        val result = api.getLocationList(IdDto("14BB8E98-6586-4EA7-B4D7-35D6A63F5AA3"))

        assertThat(result.isNotEmpty(), `is`(true) )
    }
    @Test
    fun `WHEN request hero2 location EXPECT result`() = runTest {
        val result = api.getLocationList(IdDto("81D51BD2-E82C-4E1D-8216-BDFB107C1F28"))

        assertThat(result, instanceOf(List::class.java) )
    }
    @Test(expected = HttpException::class)
    fun `WHEN request unknown location EXPECT throws exception`() = runTest {
        api.getLocationList(IdDto("81D51BD2-E82Casdfgg-4E1D-8216-BDFB107C1F28"))

        assert(false)
    }


    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                //Lo ideal es probar contra un entorno estable
                    //Entorno de QA
                .baseUrl("https://dragonball.keepcoding.education/")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor(
                            HttpLoggingInterceptor.Logger.DEFAULT)
                            .apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                )
                .build()
        }

    }
}