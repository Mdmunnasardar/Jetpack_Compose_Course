package com.example.jetpackcomposecourse.buttomnevigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
// WindowInsets are generally handled well by Scaffold and Material 3 components,
// but explicit padding for the content area using innerPadding is key.
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar // Import Material 3 NavigationBar
import androidx.compose.material3.NavigationBarItem // Import Material 3 NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable // Use rememberSaveable for state restoration
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

// Data class for navigation items
data class BottomNavigationScreen(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String // Unique route for navigation (if using NavController)
)

@Composable
fun StandardBottomNavigationBar() {
    // Keep track of the selected item's index.
    // Use rememberSaveable to preserve this state across configuration changes.
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    val items = listOf(
        BottomNavigationScreen(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "home"
        ),
        BottomNavigationScreen(
            title = "WishList",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder, // Using FavoriteBorder for outlined
            route = "wishlist"
        ),
        BottomNavigationScreen(
            title = "Cart",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            route = "cart"
        ),
        BottomNavigationScreen(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = "profile"
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                // You can customize containerColor and contentColor if needed
                // containerColor = MaterialTheme.colorScheme.surface,
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            // TODO: Here you would typically navigate to the item.route
                            // using a NavController if you have one set up.
                            // e.g., navController.navigate(item.route) { launchSingleTop = true }
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            Icon(
                                imageVector = if (selectedItemIndex == index) {
                                    item.selectedIcon
                                } else {
                                    item.unselectedIcon
                                },
                                contentDescription = item.title
                            )
                        },
                        // You can customize colors for selected/unselected items if needed
                        // colors = NavigationBarItemDefaults.colors(
                        // indicatorColor = MaterialTheme.colorScheme.secondaryContainer
                        // )
                    )
                }
            }
        }
    ) { innerPadding ->
        // This is where the content for the selected screen would go.
        // It uses the innerPadding provided by the Scaffold to avoid overlapping
        // with the top app bar (if any) and the bottom navigation bar.
        Box(
            modifier = Modifier
                .padding(innerPadding) // Apply padding from Scaffold
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Display content based on selectedItemIndex
            // For a real app, this would be replaced by your screen composables
            // and navigation logic.
            Text(text = "Content for: ${items[selectedItemIndex].title}")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StandardBottomNavigationBarPreview() {
    // It's good practice to wrap previews in your app's theme
    // if it defines MaterialTheme colors.
    // YourAppTheme { // Replace YourAppTheme with your actual theme if you have one
    StandardBottomNavigationBar()
    // }
}

