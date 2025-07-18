package com.example.jetpackcomposecourse.corecomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler

import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun PartiallySelectlableText(){

    Box(modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center
    ){

        SelectionContainer { //this selection container is used to select text like to copy the text

            Column {

                Text("This is a text can be select")
                Text("this one too")
                Text("this is the third")
                DisableSelection {

                    Text("this is not selectable one")
                    Text("this is not selectable text")

                }
            }
        }



    }
}




@Composable
fun AnnotatedStringwithListenerSample(){

    val uriHandler = LocalUriHandler.current


    Box(modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center
    ){

        Text(


            buildAnnotatedString {

                append("Build better apps faster with")
                val link = LinkAnnotation.Url( //this the url link LinkAnnotation

                    "https://github.com/Mdmunnasardar",
                    TextLinkStyles(

                        SpanStyle(
                            color = Color.Blue
                        )
                    )
                ){

                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)// to open

                }

                withLink(link){
                    append("JetPack compose")//to link attached to the text
                }
            }

        )
    }


}


@Preview(showSystemUi = true)
@Composable
fun PreviewSelectable() {

    AnnotatedStringwithListenerSample()
    //PartiallySelectlableText()

}









