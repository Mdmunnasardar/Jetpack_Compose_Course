package com.example.jetpackcomposecourse.scaffold // Assuming package based on previous context

import androidx.compose.foundation.layout.Arrangement // Added import
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth // Added import
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons // Added import
import androidx.compose.material.icons.filled.Add // Added import
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api // Added for TopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon // Added import
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults // Recommended for TopAppBar colors
// import androidx.compose.material3.TopAppBarColors // Direct constructor usage is often internal
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // Added import
import androidx.compose.runtime.mutableIntStateOf // Changed from mutableStateOf(0) for clarity
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue // Added import
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign // Added import
import androidx.compose.ui.tooling.preview.Preview // Added for preview
import androidx.compose.ui.unit.dp // Added import

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar is often experimental
@Composable
fun scaffoldExample() {
    // State: Tracks how many times the FAB has been pressed.
    var presses by remember { mutableIntStateOf(0) }

    // Scaffold provides the basic Material Design layout structure.
    Scaffold(
        topBar = {
            // Top App Bar: Sits at the top of the screen.
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors( // Use Defaults for color configuration
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            // Bottom App Bar: Sits at the bottom of the screen.
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                // Text content within the Bottom App Bar.
                Text(
                    modifier = Modifier
                        .fillMaxWidth(), // Makes the text take full width for centering
                    textAlign = TextAlign.Center, // Centers the text
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            // Floating Action Button (FAB): For a primary action.
            FloatingActionButton(onClick = { presses++ }) { // Increment 'presses' on click
                Icon(Icons.Default.Add, contentDescription = "Add") // Standard "Add" icon
            }
        }
    ) { innerPadding -> // 'innerPadding' ensures content isn't obscured by bars/FAB.
        // Main content area of the Scaffold.
        Column(
            modifier = Modifier
                .padding(innerPadding) // Apply padding from Scaffold
                .fillMaxSize(), // Fill available space (added after padding for correct behavior)
            verticalArrangement = Arrangement.spacedBy(16.dp), // Space items vertically
        ) {
            // Text content displayed within the Column.
            Text(
                modifier = Modifier.padding(8.dp), // Padding around this specific text
                text =
                    """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(), // Removes leading whitespace from multi-line string
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldExamplePreview() {
    // Optional: Wrap with your app's theme if not applied at a higher level
    // YourTheme {
    ScaffoldExample()
    // }
}

