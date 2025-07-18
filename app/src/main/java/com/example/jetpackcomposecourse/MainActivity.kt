package com.example.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.corecomponent.AnnotatedStringwithListenerSample
import com.example.jetpackcomposecourse.corecomponent.FilledButtonSample
import com.example.jetpackcomposecourse.corecomponent.PasswordTextFieldSample
import com.example.jetpackcomposecourse.corecomponent.TonalButtonSample
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

                //AccessStringResources()
                //PasswordTextFieldSample()
                //AnnotatedStringwithListenerSample()
                //FilledButtonSample()
                TonalButtonSample()

            }
            }
        }
    }
//
//@Preview(showSystemUi = true)
//@Composable
//fun   Preview() {
//    //AccessStringResources()
//    //PasswordTextFieldSample()
//    //AnnotatedStringwithListenerSample()
//    FilledButtonSample()
//
//
//}
//

