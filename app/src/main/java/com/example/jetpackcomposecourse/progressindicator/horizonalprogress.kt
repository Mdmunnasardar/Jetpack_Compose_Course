package com.example.jetpackcomposecourse.progressindicator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun IndeterminateCircularIndicator() {
    // State to control the visibility of the progress indicator
    var loading by remember { mutableStateOf(false) }

    // Optional: If you want the loading to stop automatically after some time,
    // you can add a LaunchedEffect similar to your CircularIndicatorEx example.
     LaunchedEffect(loading) {
         if (loading) {
             delay(3000) // Simulate loading for 3 seconds
             loading = false // Stop loading
         }
     }

    // Column to arrange UI elements vertically and center them.
    // This provides a basic layout for the button and the indicator.
    Column(
        modifier = Modifier.fillMaxSize(), // Fill the available screen space
        horizontalAlignment = Alignment.CenterHorizontally, // Center children horizontally
        verticalArrangement = Arrangement.Center // Center children vertically
    ) {
        // Button to trigger the loading state
        Button(
            onClick = { loading = true }, // Set loading to true when clicked
            enabled = !loading // Disable button if already loading
        ) {
            Text("Start loading")
        }

        // Only display the indicator and spacer if loading is true
        if (loading) {
            Spacer(modifier = Modifier.height(25.dp)) // Add some space between button and indicator

            LinearProgressIndicator(
                modifier = Modifier.width(64.dp), // Set a specific width for the indicator
                color = MaterialTheme.colorScheme.secondary, // Customize the indicator's color
                trackColor = MaterialTheme.colorScheme.surfaceVariant, // Customize the track color
            )
        }
    }
}

// Preview for IndeterminateCircularIndicator
@Preview(showSystemUi = true, name = "Indeterminate Indicator Preview")
@Composable
fun IndeterminateCircularIndicatorPreview() {
    // Optional: Wrap with your app's theme for a more accurate preview
    // YourAppTheme {
    IndeterminateCircularIndicator()
    // }
}

// Your existing CircularIndicatorEx and its preview (if you want to keep them in the same file)


@Preview(showSystemUi = true, name = "CircularIndicatorEx Preview")
@Composable
fun Preview() {
    CircularIndicatorEx()
}
