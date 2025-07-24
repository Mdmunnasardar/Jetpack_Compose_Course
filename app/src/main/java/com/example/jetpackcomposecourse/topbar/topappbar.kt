package com.example.jetpackcomposecourse.topbar


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    androidx.compose.material3.TopAppBar(

        title = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(22.dp)


                ) {
                    Text(
                        text = "Home", color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDownward, contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(top = 6.dp),
                        tint = Color.DarkGray,

                        )
                }
                Text(
                    text = "this is the location Delhi",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold

                )
            }
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.LocationOn, contentDescription = null,
                modifier = Modifier.size(35.dp),
                tint = Color.Red,

                )
        },
        actions = {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.LightGray, CircleShape),
                contentAlignment = Alignment.Center
            ) {

                Text("H", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Blue)

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.White),
        modifier = Modifier.padding(horizontal = 4.dp)
    )


}

@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {

    TopAppBar()
}


