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
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidsuperpoderes.R


const val LOGIN_TEXT_FIELD_USER = "LOGIN_TEXT_FIELD_USER"
const val LOGIN_TEXT_FIELD_PASSWORD= "LOGIN_TEXT_FIELD_PASSWORD"

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onForgotPassword: () -> Unit) {

    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragon_ball_super),
            modifier = Modifier.size(300.dp, 200.dp),
            contentDescription = "SuperHero application"
        )
        Text(text = "Android SuperPoderes", fontSize = 30.sp)

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )

        TextField(
            modifier=Modifier.testTag(LOGIN_TEXT_FIELD_USER),
            value = email,
            placeholder = { Text(text = "Email") },
            onValueChange = { email = it },
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    modifier = Modifier.alpha(0.5f)
                )
            })

        TextField(
            modifier=Modifier.testTag(LOGIN_TEXT_FIELD_PASSWORD),
            value = password,
            placeholder = { Text(text = "Password") },
            onValueChange = { password = it },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "password",
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

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )

        Button(
            onClick = {
                      onLoginSuccess()
                /*if(authenticate(email, password)){
                        onLoginSuccess()
                    }*/
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ) {
            Text(text = stringResource(R.string.login))
        }
        Button(
            onClick = onForgotPassword,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Black
            )
        ) {
            Text(text = "ForgotPassword")
        }
    }
}



@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({},{})
}

fun authenticate(user: String, password: String) = user=="ejemplo@gmail.com" && password=="password"