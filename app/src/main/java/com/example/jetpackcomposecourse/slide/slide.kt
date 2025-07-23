package com.example.jetpackcomposecourse.slide

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SliderEx() {

    // Remembers the slider's current spot (value). Starts at 0.
    var sliderposition by remember {
        mutableStateOf(0f)
    }

    // Arranges items in a column, centered on the screen.
    Column(
        modifier = Modifier.fillMaxSize(), // Takes up the whole screen.
        horizontalAlignment = Alignment.CenterHorizontally, // Center items left-to-right.
        verticalArrangement = Arrangement.Center // Center items top-to-bottom.
    ) {
        // The actual slider users can drag.
        Slider(
            value = sliderposition, // Current spot of the slider's handle.
            onValueChange = { newPosition ->
                sliderposition = newPosition // Update spot when user drags.
            },
            colors = SliderDefaults.colors( // Sets the slider's colors.
                thumbColor = MaterialTheme.colorScheme.secondary, // Color of the draggable handle.
                activeTrackColor = MaterialTheme.colorScheme.secondary, // Color of the filled part of the track.
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer // Color of the empty part of the track.
            ),
            steps = 10, // Divides the slider into 10 sections (11 possible spots).
            valueRange = 0f..50f // Slider can go from 0 to 50.
        )
        // Shows the slider's current number value as text.
        Text(text = sliderposition.toString())
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    // Wraps the example in your app's theme for correct colors.
    MaterialTheme {
        SliderEx() // Shows the SliderEx composable in the preview.
    }
}

//https://developer.android.com/develop/ui/compose/components/slider