package com.example.jetpackcomposecourse.layoutcomposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Lazy Column is like scroll the data to the  bottom of the screen

@Composable
fun LazyColumnExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("LazyColumn (prefered for the lists")

        LazyColumn(

            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
        ) {

            items(100) { index->

                Text(
                    text = "Item $index in LazyColumn",
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .background(Color.White)
                )

            }
        }


    }


}

// Lazy Row can be used to display a list of items horizontally
@Composable
fun LazyRowExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("LazyRow (prefered for the lists")

        LazyRow(

            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
        ) {

            items(100) { index->

                Text(
                    text = "Item $index in LazyColumn",
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .background(Color.White)
                )

            }
        }


    }


}


@Preview(showSystemUi = true)
@Composable
fun LazyColumnExamplePreview() {
    LazyRowExample()
   // LazyColumnExample()


}
