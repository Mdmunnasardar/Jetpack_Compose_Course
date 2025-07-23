package com.example.jetpackcomposecourse.segmentedbutton // Or your actual package

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.automirrored.filled.DirectionsBike // Still unused
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
// import com.example.newjetpackcomposecourse.`16_SearchBar`.SearchScreen // Still unused


@Composable
fun SegmentedbuttonEx() {

    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }
    val options = listOf("Walk", "Ride", "Drive")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    checked = selectedOptions[index],
                    onCheckedChange = {
                        selectedOptions[index] = !selectedOptions[index]
                    },
                    icon = { // This is for the default checkmark icon
                        SegmentedButtonDefaults.Icon(active = selectedOptions[index])
                    }
                    // Remove the `label = { ... }` parameter here
                    // and use ONLY the trailing lambda for your custom icon content.
                ) { // This trailing lambda is the main content of the SegmentedButton
                    when (label) {
                        "Walk" -> Icon(
                            Icons.AutoMirrored.Filled.DirectionsWalk,
                            contentDescription = "Direction Walk"
                        )

                        "Ride" -> Icon(
                            Icons.Default.DirectionsBus, // Or DirectionsBike
                            contentDescription = "Direction Ride"
                        )

                        "Drive" -> Icon(
                            Icons.Default.DirectionsCar,
                            contentDescription = "Direction Drive"
                        )
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ExamplePreviewSegmentedButton() {
    SegmentedbuttonEx()
}
