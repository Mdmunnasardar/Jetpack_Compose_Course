package com.example.jetpackcomposecourse.switch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch // The switch component
import androidx.compose.material3.SwitchDefaults // For default values like icon size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SwitchEx() {

    // Remembers if the switch is ON (true) or OFF (false). Starts ON.
    var checked by remember { mutableStateOf(true) }

    // A box to center the switch on the screen.
    Box(
        modifier = Modifier.fillMaxSize(), // Box takes up the whole screen.
        contentAlignment = Alignment.Center // Puts content (the Switch) in the center.
    ) {
        // The actual switch users can tap.
        Switch(
            checked = checked, // Tells the Switch if it's ON or OFF.
            onCheckedChange = { isNowChecked -> // Called when the user taps the Switch.
                checked = isNowChecked // Update our 'checked' state.
            },
            thumbContent = if (checked) { // What to show inside the Switch's handle (thumb).
                { // This is a Composable function.
                    // Show a check icon if the Switch is ON.
                    Icon(
                        imageVector = Icons.Filled.Check, // The checkmark picture.
                        contentDescription = null, // No need for description for a purely decorative icon here.
                        modifier = Modifier.size(SwitchDefaults.IconSize) // Make icon correct size for Switch.
                    )
                }
            } else {
                null // Show nothing in the thumb if the Switch is OFF.
            }
        )
    }
}

@Preview(showSystemUi = true) // Shows this Composable in Android Studio's preview.
@Composable
fun ExamplePreview() {
    SwitchEx() // Previews our Switch example.
}
//https://getbootstrap.com/docs/5.3/forms/checks-radios/