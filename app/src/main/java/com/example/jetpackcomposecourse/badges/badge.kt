package com.example.jetpackcomposecourse.badges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.filled.Add // Not used, can be removed
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge // The small notification circle
import androidx.compose.material3.BadgedBox // Container that places a Badge on content
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api // For using experimental Badge/BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment // For Column horizontalAlignment (already available via Modifier)
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class) // Using experimental Material 3 components.
@Composable
fun BadgeInteractiveExample() {
    // Remembers the number of items. Starts at 0.
    var itemCount by remember { mutableStateOf(0) }

    // Arranges items in a column, centered on the screen.
    Column(
        modifier = Modifier.fillMaxSize(), // Takes up the whole screen.
        horizontalAlignment = Alignment.CenterHorizontally, // Center items left-to-right.
        verticalArrangement = Arrangement.Center // Center items top-to-bottom.
    ) {
        // A box that can have a badge attached to its content.
        BadgedBox(
            badge = { // Defines what the badge looks like.
                // Only show the badge if there's at least one item.
                if (itemCount > 0) {
                    Badge( // The actual badge component.
                        containerColor = Color.Red, // Background color of the badge.
                        contentColor = Color.White // Text color inside the badge.
                    ) {
                        Text("$itemCount") // Shows the current item count in the badge.
                    }
                }
            }
        ) { // This is the content the badge will be placed on.
            Icon(
                imageVector = Icons.Filled.ShoppingCart, // The shopping cart icon.
                contentDescription = "Shopping Cart" // Description for accessibility.
            )
        }

        // A button to add items.
        Button(
            onClick = {
                itemCount++ // Increase the item count when clicked.
            }
        ) {
            Text("Add item") // Text on the button.
        }
    }
}


@Preview(showSystemUi = true) // Shows this Composable in Android Studio's preview.
@Composable
fun ExamplePreview() {
    BadgeInteractiveExample() // Previews our badge example.
}

////to display a small visual element to denote status or a
// numeric value on another composable.
//https://developer.android.com/develop/ui/compose/components/badges