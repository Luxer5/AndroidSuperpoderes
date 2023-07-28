package com.example.androidsuperpoderes.presentation.login

import android.util.Log
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map

class FlowExamples {
    suspend fun Exercise1(){
        val flow1 = listOf("Goku", "Piccolo", "Freezer")
            .asFlow()
            .map {
                "Hola, $it, estas en la posicion"
            }


        flow1.collectIndexed{ index, value ->
            Log.d("Test", "$value $index")
        }
    }

    suspend fun  exercise2(){
        val flow2 = listOf("Goku", "Piccolo", "Freezer")
            .asFlow()
            .filter {
                it.length %2 == 1
            }

        flow2.collect{
            Log.d("Exercise2", "$it Numero de letras: ${it.length}")
        }
    }

    suspend fun exampleFold(){
        val flow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }
        Log.d("ExampleFold", "Before")

        val result = flow.fold("Test"){acc, value ->
            acc +value
        }
        Log.d("ExampleFold", result.toString())
    }

}