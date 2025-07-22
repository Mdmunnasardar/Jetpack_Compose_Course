package com.example.jetpackcomposecourse.scaffold


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors // Note: TopAppBarColors constructor is an internal API
import androidx.compose.material3.TopAppBarDefaults // Recommended way to get colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Marks the use of experimental Material 3 APIs
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(){

    // State for tracking FloatingActionButton presses
    var presses by remember { mutableStateOf(0) }

    // Scaffold provides a basic Material Design visual layout structure
    Scaffold(
        topBar = {
            // Top app bar displayed at the top of the screen
            TopAppBar(
                // It's generally recommended to use TopAppBarDefaults.topAppBarColors()
                // instead of constructing TopAppBarColors directly, as its constructor is internal.
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    // scrolledContainerColor will be derived if not set, or can be customized
                ),
                title = { Text("Top app bar") }
            )
        },
        bottomBar = {
            // Bottom app bar displayed at the bottom
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                // Content for the BottomAppBar
                Text(
                    text = "Bottom App Bar",
                    modifier = Modifier
                        .padding(16.dp) // Padding for the text
                        .fillMaxWidth(), // Make text take full width to center it
                    textAlign = TextAlign.Center // Center the text within BottomAppBar
                )
            }
        },
        floatingActionButton = {
            // Floating Action Button for primary actions
            FloatingActionButton(onClick = { presses++ }) { // Increment press count on click
                Text("Clicked $presses times") // Display press count
            }
        }
    ) { innerPadding -> // Content area of the Scaffold, innerPadding handles space for bars/FAB
        // Main content of the screen
        Column(
            modifier = Modifier
                .fillMaxSize() // Fill all available space
                .padding(innerPadding) // Apply padding to avoid overlapping with bars/FAB
                .background(Color.Yellow) // Background color for content area
        ) {
            Text("this is the scaffold content")
        }
    }
}

// Preview for Android Studio
@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    ScaffoldExample()
}

//https://developer.android.com/develop/ui/compose/components/scaffold