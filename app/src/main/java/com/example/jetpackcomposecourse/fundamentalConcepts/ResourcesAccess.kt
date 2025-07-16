package com.example.jetpackcomposecourse.fundamentalConcepts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecourse.R

@Composable
fun AccessStringResources(){

    Box(
        modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center
    ){
       // String and color comes from res file color.xml and strings.xml.
        // R indicates its res file and its import by import com.example.jetpackcomposecourse.R
        Text(text = stringResource(R.string.sr),color= colorResource(R.color.lavender))

    }
}
@Composable
fun AccessImageResources(){
    Box(
        modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center
    ){
        //Access image from drawable folder
        Image(painter = painterResource(R.drawable.imagebg), contentDescription = null)
    }
}







@Preview(showSystemUi = true)
@Composable

fun ResourcePreview(){
   AccessStringResources()
    AccessImageResources()

}