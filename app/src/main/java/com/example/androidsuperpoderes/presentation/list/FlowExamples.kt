package com.example.androidsuperpoderes.presentation.list

import android.util.Log
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList

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

    suspend fun exerciseSum(){
        val flow= listOf(1,5,7,8).asFlow()
        //mostrar un log sumatorio usando flows
        val result = flow.reduce {
                acc, b -> acc + b
        }
            Log.d("Ejercicio3", "Sumatorio: $result")

    }

    suspend fun exercise3(){
        val flow = listOf(
            "Maestro Roshi",
            "Krilin",
            "Mr. Satan",
            "Goku",
            "Bulma"
        )

        val result = flow.asFlow().filter {
            it.length % 2 == 1
        }
            .take(2)
            .reduce(){acc , value ->
            "$acc y $value"
            }


        Log.d("Exercise4", "Bienvenidos,  $result" )
    }

}