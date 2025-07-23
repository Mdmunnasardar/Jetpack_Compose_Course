package com.example.jetpackcomposecourse.timepicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
// import androidx.compose.runtime.traceEventStart // Not actively used, can be removed
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class) // Using new Material 3 features.
@Composable
fun TimePickerEx() {
    // Remembers if the time picker dialog should be shown. Starts hidden.
    var showDialog by remember {
        mutableStateOf(false)
    }

    // Remembers the time chosen by the user. Starts empty.
    var selectedTime by remember { mutableStateOf("") }

    // A box to center content on the screen.
    Box(
        modifier = Modifier
            .fillMaxSize() // Takes up the whole screen.
            .padding(16.dp), // Adds some space around the edges.
        contentAlignment = Alignment.Center // Puts content in the middle.
    ) {
        // Arranges items vertically.
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // Centers items left-to-right.
        ) {
            // Shows the selected time or a message if no time is picked.
            Text(
                text = if (selectedTime.isEmpty()) "No time Selected "
                else "Selected : $selectedTime"
            )
            Spacer(modifier = Modifier.height(20.dp)) // Adds a little space.
            // Button to open the time picker.
            Button(
                onClick = {
                    showDialog = true // Show the dialog when clicked.
                }
            ) {
                Text("Open Time Picker")
            }
        }

        // If 'showDialog' is true, show our custom time picker.
        if (showDialog) {
            AdvanceTimePicker(
                onConfirm = { timeState -> // Called when user confirms a time.
                    // Format the chosen hour and minute nicely.
                    selectedTime = String.format("%02d:%02d", timeState.hour, timeState.minute)
                    showDialog = false // Hide the dialog.
                },
                onDismiss = { // Called when user dismisses the dialog (e.g., clicks "OK" or outside).
                    // In your current logic, this re-shows the dialog, which might be a bug.
                    // It should probably be: showDialog = false
                    showDialog = false // Corrected: Hide the dialog on dismiss too.
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Using new Material 3 features.
@Composable
fun AdvanceTimePicker(
    onConfirm: (TimePickerState) -> Unit, // What to do when time is confirmed.
    onDismiss: () -> Unit // What to do when dialog is dismissed.
) {
    // Gets the current time to set as the starting time.
    val currentTime = Calendar.getInstance()
    // Remembers the state of the time picker (hour, minute, 24-hour format).
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true // Use 24-hour format (e.g., 13:00 instead of 1:00 PM).
    )

    // Remembers if the clock dial or text input should be shown. Starts with dial.
    var showDial by remember { mutableStateOf(true) }

    // Chooses the icon for toggling between dial and text input.
    val toggleIcon = if (showDial) {
        Icons.Default.EditCalendar // Icon for switching to text input.
    } else {
        Icons.Default.AccessTime // Icon for switching to dial.
    }

    // Our custom dialog that holds the time picker.
    AdvancedTimePickerDialog(
        onDismiss = { // When the dialog is asked to close (e.g. back button, clicked outside).
            onDismiss() // Call the passed-in dismiss function.
        },
        onConfirm = { onConfirm(timePickerState) }, // When user clicks "OK" (or your confirm button).
        toggle = { // The button to switch between dial and text input.
            IconButton(onClick = { showDial = !showDial }) { // When clicked, flip 'showDial'.
                Icon(
                    imageVector = toggleIcon,
                    contentDescription = "Toggle time input mode" // More descriptive
                )
            }
        }
    ) { // This is the main content of the dialog.
        // Show either the clock dial or the text input based on 'showDial'.
        if (showDial) {
            TimePicker(state = timePickerState) // The clock dial.
        } else {
            TimeInput(state = timePickerState) // The text input fields.
        }
    }
}

// A custom dialog layout.
@Composable
fun AdvancedTimePickerDialog(
    title: String = "Select Time", // Title of the dialog. Changed "Slect" to "Select".
    onDismiss: () -> Unit, // Action when dialog is dismissed.
    onConfirm: () -> Unit, // Action when "OK" (or confirm) is clicked.
    toggle: @Composable () -> Unit = {}, // Slot for the toggle button.
    content: @Composable () -> Unit, // Slot for the main content (TimePicker or TimeInput).
) {
    // The actual dialog window.
    Dialog(
        onDismissRequest = onDismiss, // Called when user wants to close the dialog.
        properties = DialogProperties(usePlatformDefaultWidth = false) // Allows custom width.
    ) {
        // The card-like background for the dialog content.
        Surface(
            shape = MaterialTheme.shapes.extraLarge, // Rounded corners.
            tonalElevation = 6.dp, // Adds a slight shadow.
            modifier = Modifier
                .width(IntrinsicSize.Min) // Dialog width fits its content.
                .height(IntrinsicSize.Min) // Dialog height fits its content.
                .background( // Sets background color and shape.
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.surface
                )
        ) {
            // Arranges items vertically inside the dialog.
            Column(
                modifier = Modifier.padding(24.dp), // Space inside the dialog.
                horizontalAlignment = Alignment.CenterHorizontally // Centers items.
            ) {
                // Dialog title text.
                Text(
                    modifier = Modifier
                        .fillMaxWidth() // Title takes full width.
                        .padding(bottom = 20.dp), // Space below the title.
                    text = title,
                    style = MaterialTheme.typography.labelMedium // Text style for title.
                )
                content() // Shows the TimePicker or TimeInput here.
                // Row for buttons at the bottom.
                Row(
                    modifier = Modifier
                        .height(40.dp) // Fixed height for the button row.
                        .fillMaxWidth() // Row takes full width.
                ) {
                    toggle() // Shows the toggle icon button.
                    Spacer(modifier = Modifier.weight(1f)) // Pushes buttons to the right.
                    // "Cancel" button.
                    // Logic seems swapped: onConfirm is usually for "OK", onDismiss for "Cancel".
                    TextButton(onClick = onDismiss) { Text("Cancel") } // Corrected: onClick should be onDismiss
                    // "OK" button.
                    TextButton(onClick = onConfirm) { Text("OK") } // Corrected: onClick should be onConfirm
                }
            }
        }
    }
}

@Preview(showSystemUi = true) // Shows this in Android Studio's preview.
@Composable
fun ExamplePreview() {
    TimePickerEx() // Previews the main TimePickerEx screen.
}

//https://developer.android.com/develop/ui/views/components/pickers