package com.example.jetpackcomposecourse.progressindicator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun CircularIndicatorEx() {
    // State to control the visibility of the progress indicator
    var loading by remember { mutableStateOf(false) }

    // LaunchedEffect to simulate a loading process when 'loading' state becomes true.
    // It will run the coroutine block whenever the 'loading' key changes.
    LaunchedEffect(loading) {
        if (loading) { // Only run if loading is true
            delay(3000) // Simulate a network request or background task for 3 seconds
            loading = false // Reset loading state to hide the indicator after the delay
        }
    }

    // Column to arrange UI elements vertically and center them on the screen
    Column(
        modifier = Modifier.fillMaxSize(), // Column takes up the entire screen
        horizontalAlignment = Alignment.CenterHorizontally, // Center children horizontally
        verticalArrangement = Arrangement.Center // Center children vertically
    ) {
        // Button to trigger the loading state
        Button(
            onClick = { loading = true }, // Set loading to true when clicked
            enabled = !loading // Disable button while loading is in progress
        ) {
            Text("Start Loading")
        }

        Spacer(modifier = Modifier.height(15.dp)) // Adds vertical space between button and indicator

        // Conditionally display the CircularProgressIndicator if 'loading' is true
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp), // Set a specific width for the indicator
                color = MaterialTheme.colorScheme.secondary, // Customize the indicator's color
                trackColor = MaterialTheme.colorScheme.surfaceVariant // Customize the track color (background of the circle)
            )
        }
    }
}

// Preview for Android Studio, showing the system UI
@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    CircularIndicatorEx()
}
//https://developer.android.com/develop/ui/compose/components/progress