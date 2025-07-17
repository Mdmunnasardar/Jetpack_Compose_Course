package com.example.jetpackcomposecourse.corecomponent

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun SimpleText() {

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        //added text color and text content by directly here
        // not using color.xml and strings.xml
        Text (text = "Hello EveryOne",
            color = Color.Blue,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                //added shadow color and blur radius short text
                shadow = Shadow(
                    color = Color.Red,
                    blurRadius = 8f
                )

            )
        )

    }
}
@Composable
fun MixDifferentTextColor(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        val rainbowColors= listOf(
            Color.Red,
            Color.Blue,
            Color.Green,
            Color.Yellow,
            Color.Magenta,
            Color.Cyan
        )
        Text(
            text = buildAnnotatedString {
                append("Never Give up \n")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ){
                    append("Because hardworking payback ")
                }
                append("\n Almighty always know better than you ")
            }
        )

    }
}

@Composable
fun HorizontalTextRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("One")
        Text("Two")
        Text("Three")
    }
}


@Composable
fun MovedText(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "I am Student of computer science",
            //using basicMarquee() to move text and switch preview mod to interactive mood
            modifier = Modifier.basicMarquee(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                //added shadow color and blur radius short text
                shadow = Shadow(
                    color = Color.Red,
                    blurRadius = 8f
                )

            )

        )
    }
    }

@Composable
fun ScrollableText() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Text(
            text = "hey this is Munna Sardar experimenting with the jetpack compose".repeat(50),
            maxLines = 2,
            fontSize = 50.sp,
            overflow = TextOverflow.Ellipsis
            //using overflow to make text ellipsis..like this this 50 words which
            //is divided in two lines and after the word ellipsis like .....
        )


    }

}
@Preview(showSystemUi = true)
@Composable

fun SimpleTextPreview() {
    //SimpleText()
    //MixDifferentTextColor()
    //HorizontalTextRow()
    //MovedText()
    ScrollableText()




}