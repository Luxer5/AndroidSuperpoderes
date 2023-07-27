package com.example.androidsuperpoderes

import NavigationGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidsuperpoderes.presentation.login.LoginScreen
import com.example.androidsuperpoderes.ui.theme.AndroidSuperpoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidSuperpoderesTheme {
                NavigationGraph()
            }
        }
    }
}