package com.example.androidsuperpoderes.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidsuperpoderes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragon_ball_super),
            modifier = Modifier.size(300.dp,200.dp),
            contentDescription = ""
        )
        Text(text = "Android SuperPoderes", fontSize = 30.sp)

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )

        TextField(value = "Email", onValueChange = {}, leadingIcon = {
            Image(
                imageVector = Icons.Default.Email,
                contentDescription = "",
                modifier = Modifier.alpha(0.5f)
            )
        })

        TextField(value = "Password", onValueChange = {}, leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.password),
                contentDescription = "",
                modifier = Modifier.alpha(0.5f)
            )
        },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.visibility),
                    contentDescription = "",
                    modifier = Modifier.alpha(0.5f)
                )
            })

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

        Button(onClick = onLoginSuccess, colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow, contentColor = Color.Black)) {
            Text(text = "Login")
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({})
}