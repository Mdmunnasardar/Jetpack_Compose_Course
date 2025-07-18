package com.example.jetpackcomposecourse.corecomponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R // Assuming R class is in this package




// Displays an image with a rainbow gradient border and a grayscale color filter.
// The image is centered within a Box that fills the screen and has a light gray background.
@Composable
fun ImageShowInBoxCircular() { // Renamed for clarity

    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color.Red,
                Color.Cyan,
                Color.Yellow,
                Color.Green,
            )
        )
    }

    val borderWidth = 4.dp
    val imageSize = 300.dp // Define image size for consistency

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagebg),
            contentDescription = "This is a news image",
            contentScale = ContentScale.Crop, // Crop is important for circular images to fill the shape
            modifier = Modifier
                .size(imageSize) // Apply size first
                .border( // Apply border
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape // Make the border circular
                )
                .padding(borderWidth) // Add padding inside the border to prevent image overlap if border is thick
                .clip(CircleShape), // Clip the image content to a circle
            alignment = Alignment.Center,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToSaturation(0f)
            })
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ImageshowPreview() {
    ImageShowInBoxCircular()
}
