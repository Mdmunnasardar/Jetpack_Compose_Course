package com.example.jetpackcomposecourse.corecomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue //user input value which give it user
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue //user input set value
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SimpleOutlinedTextField() {

    //here by import to set value and getvalue
    //and remember to remember the value at last value of variable
    //like 1,2,3,4 here 4 is last value of variable that why it remember 4
    // also we can use rememberSaveable to remember the value like
    // after the end of the session of app
    var text by remember {
        mutableStateOf("") //user input value remember and mutableStateOf is change value

    }

    val rainbowcolors = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Magenta,
        Color.Cyan
    )
//    var text1 by remember {
//        mutableStateOf("") //user input value remember and mutableStateOf is change value
//
//    }
    val brush = remember {

        Brush.linearGradient(
            colors = rainbowcolors
        )
    }


    Box(
        modifier = Modifier.fillMaxSize(), Alignment.Center

    ) {
        TextField(  //text field is used to take input from user
            //TextField is used to take input from user  also used to change the style of text from val brush = remember {
            //its gives color to text

            value = text, onValueChange = {
                text = it
            },
            textStyle = TextStyle(brush = brush)
        )

//        OutlinedTextField(
//            value = text,
//            onValueChange = {  //when value change it will update the value and go the by calling
//                text = it
//            },
//            label = {
//                Text("label")
//                //a label is usually used in input components (like TextField, OutlinedTextField, etc.) to provide
//                // a descriptive name or hint for the user about what the input field is for.
//            }
//        )

    }
}
@Composable
fun PasswordTextFieldSample(){

    var password by rememberSaveable {

        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        TextField(

            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Enter Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )

        )
    }


}




@Preview(showSystemUi = true)
@Composable
fun Preview() {
   PasswordTextFieldSample()
}

