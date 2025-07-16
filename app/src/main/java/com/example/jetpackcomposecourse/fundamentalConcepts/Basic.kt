package com.example.jetpackcomposecourse.fundamentalConcepts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

//what is composable function--for building ui design
//A Composable function is a building block of UI in Jetpack Compose.
// It’s a special Kotlin function marked with the
// @Composable annotation that describes how your UI should look based on the current state.

@Composable
fun Greeting (){
    Text(text = "hello jetpack compose")


}
//preview is used to  preview your composable
// functions inside Android Studio without running the app on a device or emulator.
//@Preview(showSystemUi = true)
//@Composable
//fun GreetingPreview(){
    //Greeting()
//}

