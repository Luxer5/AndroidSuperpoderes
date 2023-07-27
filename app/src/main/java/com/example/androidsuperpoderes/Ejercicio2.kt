package com.example.androidsuperpoderes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Ejercicio2() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Yellow)
            )

        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(Color.Gray)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Column(modifier = Modifier, horizontalAlignment = Alignment.End) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red)
                )
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Yellow)
                )
            }

        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(Color.Gray)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Yellow)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(Color.Gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Exercise2Preview() {
    //ComposableExercise()
    Ejercicio2()
}