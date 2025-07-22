package com.example.jetpackcomposecourse.checkbox

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState // Represents on, off, or indeterminate states.
import androidx.compose.ui.tooling.preview.Preview


// Demonstrates a parent TriStateCheckbox controlling multiple child Checkboxes.
@Composable
fun CheckBoxExample() {

    // Holds the checked state of individual child checkboxes.
    // // `mutableStateListOf` makes the list reactive;
    // UI updates when items are added/removed/changed..
    val childCheckedStates = remember {
        mutableStateListOf(false, false, false)
    }

    // Determines the state of the parent TriStateCheckbox based on child states.
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On // All children checked.
        childCheckedStates.none { it } -> ToggleableState.Off // No children checked.
        else -> ToggleableState.Indeterminate // Some children checked.
    }

    // Column to arrange checkboxes vertically and centered.
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Row for the "Select all" parent checkbox.
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select all")
            // Parent checkbox that can be on, off, or indeterminate.
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    // Toggles all child checkboxes based on the parent's current state.
                    val newState = parentState != ToggleableState.On
                    for (i in childCheckedStates.indices) {
                        childCheckedStates[i] = newState
                    }
                }
            )
        }

        // Iterates through child states to create individual Checkboxes.
        childCheckedStates.forEachIndexed { index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Option ${index + 1}")
                // Standard Checkbox for an individual option.
                Checkbox(
                    checked = checked,
                    onCheckedChange = { newCheckedState ->
                        childCheckedStates[index] = newCheckedState // Updates the specific child's state.
                    }
                )
            }
        }

        // Displays a message if all options are selected.
        if (childCheckedStates.all { it }) {
            Text("All options selected")
        }
    }
}

// Previews the CheckBoxExample composable.
@Preview(showSystemUi = true)
@Composable
fun CheckExamplePreview() {
    CheckBoxExample()
}

