package com.example.jetpackcomposecourse.floatingbutton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Example(onClick: () -> Unit) {
    // Wrap the FloatingActionButton in a Box to control its alignment.
    Box(
        modifier = Modifier.fillMaxSize(), // Make the Box fill the available space.
        contentAlignment = Alignment.Center // Align content (the FAB) to the center of the Box.
    ) {
        FloatingActionButton(
            onClick = { onClick() },
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}

// Function with SmallFloatingActionButton, centered
@Composable
fun SmallExample(onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),      // Make the Box fill the available space.
        contentAlignment = Alignment.Center   // Align content (the SmallFAB) to the center.
    ) {
        SmallFloatingActionButton(
            onClick = { onClick() },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {

   // Example(onClick = {})
    SmallExample(onClick = {})

}
