package com.example.jetpackcomposecourse.corecomponent

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A sample Composable function demonstrating the usage of a filled [Button].
 *
 * This button, when clicked, will display a short [Toast] message "Clicked".
 *
 * ```
 * @Composable
 * fun FilledButtonSample(){
 *     val context = LocalContext.current
 *     Button(
 *         onClick = {
 */
//1.Filled button created
@Composable
fun FilledButtonSample() {
    val context = LocalContext.current

    // Wrap the existing Button logic within a Box
    Box(
        modifier = Modifier
            .fillMaxSize() // Make the Box fill the entire available space
            .background(Color(0xFFB0BEC5)) // Set a background color for the Box (e.g., Blue Grey)
            .padding(16.dp), // Optional: Add some padding around the content of the Box
        contentAlignment = Alignment.Center // Align the content (the Button) to the center of the Box
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Click Me")
        }
    }
}
/// 2. Tonal Button
// 🔘 TonalButton – Medium emphasis Material 3 button
// • Uses a colored background (usually secondaryContainer)
// • Draws less attention than Filled Button, more than Text or Outlined
// • Ideal for secondary actions in a UI
// • Automatically styled based on the MaterialTheme color scheme
// • Requires material3 dependency

@Composable
fun TonalButtonSample() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCFD8DC)) // Slightly different background for visual distinction
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        FilledTonalButton( // Use FilledTonalButton composable
            onClick = {
                Toast.makeText(context, "Tonal Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Tonal Button")
        }
    }
}
@Composable
fun OutlinedButtonSample() {
    val context = LocalContext.current
    Box( // Container to center the button and provide a background.
        modifier = Modifier
            .fillMaxSize() // Box fills the whole screen.
            .background(Color(0xFFECEFF1)) // Different background for visual distinction.
            .padding(16.dp), // Padding inside the Box.
        contentAlignment = Alignment.Center // Centers content (Button) in the Box.
    ) {
        OutlinedButton( // This is the Outlined Button.
            onClick = {
                Toast.makeText(context, "Outlined Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Outlined Button")
        }
    }
}
@Composable
fun ElevatedButtonSample() {
    val context = LocalContext.current
    Box( // Container to center the button and provide a background.
        modifier = Modifier
            .fillMaxSize() // Box fills the whole screen.
            .background(Color(0xFFF5F5F5)) // A neutral background for the Box.
            .padding(16.dp), // Padding inside the Box.
        contentAlignment = Alignment.Center // Centers content (Button) in the Box.
    ) {
        ElevatedButton( // This is the ElevatedButton.
            onClick = {
                Toast.makeText(context, "Elevated Button Clicked", Toast.LENGTH_SHORT).show()
            }
            // You can customize elevation if needed, e.g.:
            // elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp, pressedElevation = 2.dp)
        ) {
            Text(text = "Elevated Button")
        }
    }
}

/// text button use for text click
@Composable
fun TextButtonSample() {
    val context = LocalContext.current
    Box( // Container to center the button and provide a background.
        modifier = Modifier
            .fillMaxSize() // Box fills the whole screen.
            .background(Color(0xFFFAFAFA)) // A very light background for the Box.
            .padding(16.dp), // Padding inside the Box.
        contentAlignment = Alignment.Center // Centers content (Button) in the Box.
    ) {
        TextButton( // This is the TextButton.
            onClick = {
                Toast.makeText(context, "Text Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Text Button")
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun FilledButtonSamplePreview(){
    //FilledButtonSample()
    //TonalButtonSample()
    //OutlinedButtonSample()
    //ElevatedButtonSample()
    TextButtonSample()
}

