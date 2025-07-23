package com.example.jetpackcomposecourse.datepicker

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DatePickerEx() {
    // Remembers the chosen date (as milliseconds), or null if none.
    var selectedDate by remember { mutableStateOf<Long?>(null) }

    // Remembers if the date picker dialog should be shown. Starts hidden.
    var showModal by remember { mutableStateOf(false) }

    // Box to center content on the screen.
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Text field to show date and open picker on tap.
        OutlinedTextField(
            value = selectedDate?.let { convertMillisToDateString(it) } ?: "", // Show date or empty.
            onValueChange = { /* Not directly editable */ },
            label = { Text("DoB") }, // Field label.
            placeholder = { Text("MM/DD/YYYY") }, // Hint text.
            trailingIcon = { // Icon at the end of the field.
                Icon(Icons.Default.DateRange, contentDescription = "Select date")
            },
            modifier = Modifier
                .fillMaxWidth() // Field takes full width.
                .pointerInput(Unit) { // Handles tap gestures on the field.
                    awaitEachGesture {
                        awaitFirstDown(pass = PointerEventPass.Initial) // Wait for touch down.
                        val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial) // Wait for touch up.
                        if (upEvent != null) { // If tap was completed.
                            showModal = true // Show the date picker dialog.
                        }
                    }
                }
        )
    }

    // If 'showModal' is true, show the date picker dialog.
    if (showModal) {
        DatePickerModal(
            onDateSelected = { dateInMillis -> // When a date is picked and confirmed.
                selectedDate = dateInMillis // Update the selected date.
                showModal = false // Hide the dialog.
            },
            onDismiss = { // When dialog is dismissed without confirming.
                showModal = false // Hide the dialog.
            }
        )
    }
}

// Converts milliseconds (Long) to a "dd/MM/yyyy" date string.
fun convertMillisToDateString(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class) // Using new Material 3 features.
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit, // Action when date is picked & "OK" is clicked.
    onDismiss: () -> Unit // Action when dialog is dismissed (Cancel, click outside).
) {
    // Remembers the state of the date picker (selected date, displayed month, etc.).
    val datePickerState = rememberDatePickerState()

    // The dialog box that shows the DatePicker.
    DatePickerDialog(
        onDismissRequest = onDismiss, // Called when user clicks outside or presses back.
        confirmButton = { // The "OK" button.
            TextButton(
                onClick = {
                    // Pass the selected date from picker's state.
                    // The onDateSelected lambda (from DatePickerEx) will also handle closing the dialog.
                    onDateSelected(datePickerState.selectedDateMillis)
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = { // The "Cancel" button.
            TextButton(
                onClick = onDismiss // Call the dismiss action (closes dialog).
            ) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState) // The actual calendar view.
    }
}

@Preview(showSystemUi = true) // Shows this in Android Studio's preview.
@Composable
fun ExamplePreview() {
    DatePickerEx() // Previews the main DatePickerEx screen.
}
