package com.example.jetpackcomposecourse.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Wishlist : Routes("wishlist")
}