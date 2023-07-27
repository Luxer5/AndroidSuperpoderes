package com.example.androidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.example.androidsuperpoderes.data.HeroRepository
import com.example.androidsuperpoderes.data.HeroRepositoryImpl
import com.example.androidsuperpoderes.data.local.HeroDao
import com.example.androidsuperpoderes.data.local.HeroDatabase
import com.example.androidsuperpoderes.data.local.LocalDataSource
import com.example.androidsuperpoderes.data.local.LocalDataSourceImpl
import com.example.androidsuperpoderes.data.remote.RemoteDataSource
import com.example.androidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.example.androidsuperpoderes.data.remote.SuperHeroApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT ).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl("https://dragonball.keepcoding.education/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi>{
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
    single<HeroRepository> { HeroRepositoryImpl(get(), get()) }

    single<RemoteDataSource>{ RemoteDataSourceImpl(get())}

    single <LocalDataSource> { LocalDataSourceImpl(get())}

    single<SuperHeroApi>{
        getSuperHeroApi(get())
    }

    single{
        getDatabase(get())
    }

    single{
        providesHeroDao(get())
    }

}

private fun getSuperHeroApi(retrofit: Retrofit) = retrofit.create(SuperHeroApi::class.java)

private fun getDatabase(context: Context): HeroDatabase =
    Room.databaseBuilder(
        context,
        HeroDatabase::class.java,
        "superhero-db"
    ).build()

private fun providesHeroDao(db: HeroDatabase): HeroDao = db.superHeroDao()
