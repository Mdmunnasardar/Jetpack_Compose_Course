package com.example.jetpackcomposecourse.layoutcomposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Modifiers

// Modifiers are available in all the composables like text, button, image, column etc.
// its work on a color display
@Composable
fun ModifierExample() {


    Box(
        modifier = Modifier  //ctrl + space click to show the options
            .size(400.dp)
            .background(

                color = Color.Blue,
            ),
        contentAlignment = Alignment.Center

    ) {

        Text(
            "this is the jetpack",
            modifier = Modifier.background(Color.Yellow)
        )


    }


}


@Preview(showSystemUi = true)
@Composable
fun ModifierExamplePreview() {
    ModifierExample()

}


