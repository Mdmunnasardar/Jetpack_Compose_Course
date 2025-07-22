package com.example.jetpackcomposecourse.alertdialogue

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposecourse.R



@Composable
fun DialogWithImage(


) {

    val context = LocalContext.current

    Dialog(
        onDismissRequest = {

        }

    ) {
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.imagebg),
                contentDescription = "this is dialog image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp).fillMaxWidth()


            )
            Text(
                text = "this is the dialog",
                modifier = Modifier.padding(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "you can do anything by clicking on the button",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier.padding(8.dp)


                ) {
                    Text("Confirm")

                }

                TextButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)


                ) {
                    Text("Dismiss")

                }

            }
        }

    }


}

@Preview(showSystemUi = true)
@Composable
fun DialogExamplePreview() {

    DialogWithImage()

}