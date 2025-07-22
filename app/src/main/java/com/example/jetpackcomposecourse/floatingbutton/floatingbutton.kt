package com.example.jetpackcomposecourse.floatingbutton


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



// Demonstrates a simple ExtendedFloatingActionButton centered on the screen.
@Composable
fun ExtendedFloatingActionButtonExample(){

    // Box layout to fill the entire screen and center its content.
    Box(
        modifier = Modifier.fillMaxSize(), // Box occupies all available space.
        contentAlignment = Alignment.Center  // Content within the Box is centered.
    ){
        // ExtendedFloatingActionButton is a Material Design component that's wider
        // than a regular FAB and includes a text label alongside an optional icon.
        ExtendedFloatingActionButton(
            onClick = {
                // Action to perform when the FAB is clicked.
                // Currently empty.
            },
            // The content lambda defines what's displayed inside the FAB.
            content = {
                Text("this is Floating button") // Text label for the FAB.
            }
        )
    }
}
//to know details https://developer.android.com/develop/ui/compose/components/fab

@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {

    ExtendedFloatingActionButtonExample()

}

// also check the next Large and small floating button