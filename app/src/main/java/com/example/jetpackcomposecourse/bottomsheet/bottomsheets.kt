package com.example.jetpackcomposecourse.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Demonstrates a ModalBottomSheet supporting partial expansion.
@OptIn(ExperimentalMaterial3Api::class) // For ModalBottomSheet API.
@Composable
fun PartialBottomSheet() {

    // State to control bottom sheet visibility.
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    // State for the bottom sheet (expanded, partially expanded, hidden).
    // `skipPartiallyExpanded = false` enables the partially open state.
    var sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    // Column to center the button.
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Button to show the bottom sheet.
        Button(
            onClick = {
                showBottomSheet = true
            }
        ) {
            Text(text = "Open Bottom Sheet")
        }

        // Conditionally show ModalBottomSheet.
        if (showBottomSheet) {

            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(), // Sheet can fill height.
                sheetState = sheetState,             // Links to sheet's positional state.
                onDismissRequest = {                 // Handles dismissal (swipe/scrim tap).
                    showBottomSheet = false
                }
            ) {
                // Content inside the bottom sheet.
                Text(
                    text = "This is the bottom sheet, swipe up for the open and down for close",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

// Previews the PartialBottomSheet.
@Preview(showSystemUi = true)
@Composable
fun BottomExamplePreview() {
    PartialBottomSheet()
}

