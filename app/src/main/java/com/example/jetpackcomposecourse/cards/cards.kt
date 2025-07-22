import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Displays an ElevatedCard centered on the screen.//use for banner popping
@Composable
fun ElevatedCard(){

    // Box to center content on the full screen.
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        // Material Design ElevatedCard with custom elevation and size.
        androidx.compose.material3.ElevatedCard(
            elevation = CardDefaults.cardElevation( // Sets card's shadow intensity.
                10.dp
            ),
            modifier = Modifier.size(width = 200.dp, height = 100.dp) // Defines card dimensions.
        ) {
            // Text content inside the card.
            Text("this is the elevated card",
                modifier = Modifier.padding(16.dp), // Padding around the text.
                textAlign = TextAlign.Center        // Centers text horizontally.
            )
        }
    }
}

// Previews the ElevatedCard composable.
@Preview(showSystemUi = true)
@Composable
fun BottomExamplePreview() {
    ElevatedCard()
}
