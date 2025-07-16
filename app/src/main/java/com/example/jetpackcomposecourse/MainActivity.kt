package com.example.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecourse.fundamentalConcepts.AccessStringResources
import com.example.jetpackcomposecourse.fundamentalConcepts.Greeting
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

// MainActivity is the entry point of an app — the first screen that launches when a user opens the app.
// It's typically the main Activity class, and in Jetpack Compose apps,
// it's where the Compose UI is initialized.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //this the package of this project in the theme
            JetpackComposeCourseTheme {

                AccessStringResources()
                


                }
            }
        }
    }

@Preview(showSystemUi = true)
@Composable
fun   AccessStringResources() {
    AccessStringResources()


}


