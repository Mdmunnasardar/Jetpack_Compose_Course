package com.example.jetpackcomposecourse.menus

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropDownmenuExample() {

    // State to control if the menu is open or closed
    var expanded by remember {
        mutableStateOf(false)
    }

    // Main container, aligns menu button to top-right
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ){
        // Inner Box for padding the IconButton and anchoring the DropdownMenu
        Box(
            modifier = Modifier
                .padding(16.dp) // Add some space from screen edges
        ) {
            // Button to toggle the dropdown menu
            IconButton(
                onClick = { expanded = !expanded } // Click to open/close
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "Open menu") // 3-dot icon
            }

            // The actual dropdown menu
            DropdownMenu(
                expanded = expanded, // Show/hide based on 'expanded' state
                onDismissRequest = { expanded = false } // Close if clicked outside
            ) {
                // Menu item: Profile
                DropdownMenuItem(
                    text = { Text("Profile") },
                    trailingIcon = { Icon(Icons.Outlined.Person, contentDescription = "Profile icon") },
                    onClick = {
                        // TODO: Handle Profile click
                        expanded = false // Close menu after click
                    }
                )

                // Menu item: Settings
                DropdownMenuItem(
                    text = { Text("Setting") },
                    trailingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "Settings icon") },
                    onClick = {
                        // TODO: Handle Settings click
                        expanded = false // Close menu after click
                    }
                )

                HorizontalDivider() // Visual separator

                // Menu item: About
                DropdownMenuItem(
                    text = { Text("About") },
                    trailingIcon = { Icon(Icons.Outlined.AccountBox, contentDescription = "About icon") },
                    onClick = {
                        // TODO: Handle About click
                        expanded = false // Close menu after click
                    }
                )
            }
        }
    }
}

// Preview for Android Studio
@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    DropDownmenuExample()
}
//checkout to know more details https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary