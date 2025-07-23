package com.example.jetpackcomposecourse.snackbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch // Needed to show Snackbar outside of a Composable's direct recomposition


@Composable
fun SnackBArEX() { // Composable function for the screen
    // Used to launch coroutines (like showing a Snackbar) outside of Composable's direct execution.
    val scope = rememberCoroutineScope()

    // Remembers the state needed to show and manage Snackbars.
    val snackbarHostState = remember { SnackbarHostState() }

    // A basic Material Design screen structure.
    Scaffold(
        snackbarHost = { // Defines where and how Snackbars are shown.
            SnackbarHost(hostState = snackbarHostState) // Connects to our Snackbar state.
        },
        floatingActionButton = { // Defines the floating action button.
            ExtendedFloatingActionButton( // A FAB with text and an icon.
                text = { Text(text = "Show Snackbar") }, // Text on the FAB.
                icon = { Icon(Icons.Filled.Image, contentDescription = "Image Icon") }, // Icon on the FAB.
                onClick = { // Action when the FAB is clicked.
                    scope.launch { // Show Snackbar in a coroutine.
                        val result = snackbarHostState.showSnackbar(
                            message = "Snackbar", // The main text of the Snackbar.
                            actionLabel = "Action", // Text for the button on the Snackbar.
                            duration = SnackbarDuration.Indefinite // Snackbar stays until dismissed or action taken.
                        )
                        // Checks what happened to the Snackbar.
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                // Code here runs if the "Action" button on the Snackbar was pressed.
                            }
                            SnackbarResult.Dismissed -> {
                                // Code here runs if the Snackbar was dismissed (e.g., swiped away or timed out).
                            }
                        }
                    }
                }
            )
        },
        content = { paddingValues -> // Main content area of the screen.
            // A simple Box to hold content, respecting padding from Scaffold (like for the FAB).
            Box(
                modifier = Modifier
                    .fillMaxSize() // Box takes up the whole screen.
                    .padding(paddingValues) // Applies padding given by Scaffold (e.g., for FAB).
                    .padding(16.dp) // Additional padding for the content inside the Box.
            ) {
                // Text displayed on the screen.
                Text(text = "Tap the Fab to show the Snackbar")
            }
        }
    )
}


@Preview(showSystemUi = true) // Shows this Composable in Android Studio's preview.
@Composable
fun ExamplePreview() {
    SnackBArEX() // Previews our main screen Composable.
}
//https://developer.android.com/develop/ui/compose/components/snackbar

//Action Confirmation: After a user deletes an email or message, a snackbar appears to confirm the action and offer an "Undo" option.
//Network Status: When the app loses its internet connection, a snackbar pops up to note that it is now offline.
//Data Submission: Upon successfully submitting a form or updating settings, a snackbar notes that the change has saved successfully.