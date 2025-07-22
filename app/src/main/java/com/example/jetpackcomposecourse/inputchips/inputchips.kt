package com.example.jetpackcomposecourse.inputchips // Assuming package name

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
// Removed unused import: import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.tooling.preview.Preview
// Removed unused import: import com.example.newjetpackcomposecourse.`7_CheckBox`.CheckBoxExample


// Demonstrates a basic InputChip that can be enabled/disabled.
@Composable
fun InputChipExample(){

    // State to control whether the InputChip is shown (enabled).
    var enable by remember {
        mutableStateOf(true)
    }

    // Box to center the InputChip on the screen.
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        // Conditionally display the InputChip based on the `enable` state.
        if (enable){
            InputChip(
                onClick = {
                    enable = !enable // Toggles the enable state, effectively removing the chip.
                },
                label = {
                    Text("Enabled") // Text displayed on the chip.
                },
                selected = enable, // Visual state indicating if the chip is selected/active.
                avatar = { // Leading icon/avatar for the chip.
                    Icon(Icons.Filled.Person,
                        contentDescription = "Localized description", // Accessibility.
                        Modifier.size(InputChipDefaults.AvatarSize) // Standard avatar size.
                    )
                },
                trailingIcon = { // Icon displayed at the end of the chip.
                    Icon(Icons.Filled.Close,
                        contentDescription = "Localized description", // Accessibility.
                        Modifier.size(InputChipDefaults.AvatarSize) // Standard icon size.
                    )
                }
            )
        }
    }
}

// Previews the InputChipExample.
@Preview(showSystemUi = true)
@Composable
fun ChipExamplePreview() {
    InputChipExample()
}

