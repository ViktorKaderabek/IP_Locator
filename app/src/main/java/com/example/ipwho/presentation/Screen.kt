package com.example.ipwho.presentation

sealed class Screen(val route: String) {
    object MyIpScreen : Screen("my_ip_screen")
    object IpByIpScreen : Screen("ip_by_ip_screen")
    object HomeScreen : Screen("home_screen")
}