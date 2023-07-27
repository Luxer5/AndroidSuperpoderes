package com.example.androidsuperpoderes

import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidsuperpoderes.ui.theme.AndroidSuperpoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidSuperpoderesTheme {
                //ComposableExercise()
                Ejercicio2()
                /*BaseComposable {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Greeting("Android")
                        }
                    }*/
            }
        }
    }
}


@Composable
fun ComposableExercise() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(150.dp)
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Blue)
                    .align(Alignment.CenterEnd)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.White)
                    .align(Alignment.TopStart)
            )
        }

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .size(40.dp, 180.dp)
                .align(Alignment.Center)
        )

        Box(
            modifier = Modifier
                .background(Color.Black)
                .size(50.dp)
                .align(Alignment.BottomStart)
        )
    }
}




