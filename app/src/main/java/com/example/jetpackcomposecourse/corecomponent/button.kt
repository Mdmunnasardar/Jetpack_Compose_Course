package com.example.jetpackcomposecourse.corecomponent

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
@Preview(showSystemUi = true)
@Composable
fun FilledButtonSamplePreview(){
    FilledButtonSample()
}

