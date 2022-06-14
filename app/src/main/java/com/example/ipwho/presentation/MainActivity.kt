package com.example.ipwho.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ipwho.presentation.HomeScreen.HomeScreen
import com.example.ipwho.presentation.IpByIpScreen.IpByIpScreen
import com.example.ipwho.presentation.MyIpScreen.MyIpScreen
import com.example.ipwho.presentation.theme.IpWhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IpWhoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(
                            route = Screen.HomeScreen.route
                        ) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.MyIpScreen.route
                        ){
                            MyIpScreen()
                        }
                        composable(
                            route = Screen.IpByIpScreen.route
                        ){
                            IpByIpScreen()
                        }
                    }
                }
            }
        }
    }
}
