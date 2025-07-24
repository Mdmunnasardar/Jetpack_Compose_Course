package com.example.jetpackcomposecourse.buttomnevigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(val name: String, val icon: ImageVector, val unselectedIcon: ImageVector)
@Composable
fun BottomNavigationBar() {

    var selectedItem by remember { mutableIntStateOf(0) }
    val BottomNavItem= listOf(
        BottomNavItem("Home", Icons.Default.Home, unselectedIcon = Icons.Outlined.Home),
        BottomNavItem("WishList", Icons.Default.Favorite, unselectedIcon = Icons.Outlined.Favorite),
        BottomNavItem(
            "Cart", Icons.Default.ShoppingCart, unselectedIcon = Icons.Outlined.ShoppingCart
        ),
        BottomNavItem("Profile", Icons.Default.Person, unselectedIcon = Icons.Outlined.Person)

    )


}



