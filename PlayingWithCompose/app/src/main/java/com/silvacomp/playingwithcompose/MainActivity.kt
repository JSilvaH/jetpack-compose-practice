package com.silvacomp.playingwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.silvacomp.playingwithcompose.ui.theme.PlayingWithComposeTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme {
                MainScreen()
            }

        }
    }
}


@Composable
fun MainScreen() {
    val listUrl = listOf(
        "https://picsum.photos/id/237/200",
        "https://picsum.photos/id/238/200",
        "https://picsum.photos/id/239",
        "https://picsum.photos/id/240/200",
        "https://picsum.photos/id/237/200",
        "https://picsum.photos/id/238/200",
        "https://picsum.photos/id/239",
        "https://picsum.photos/id/240/200",
        "https://picsum.photos/id/237/200",
        "https://picsum.photos/id/238/200",
        "https://picsum.photos/id/239",
        "https://picsum.photos/id/240/200",
        "https://picsum.photos/id/237/200",
        "https://picsum.photos/id/238/200",
        "https://picsum.photos/id/239",
        "https://picsum.photos/id/240/200"
    )

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(listUrl) { item ->
            MyCard(text = "My Card", url = item)
        }
    }
}

@Composable
fun MyCard(text: String, url: String) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp)
            .clickable { },
        elevation = 8.dp,
        backgroundColor = Color.LightGray,

        ) {
        Box(
            Modifier.fillMaxSize()
        ){
            Text(
                fontSize = 36.sp,
                text = text,
                textAlign = Center
            )
            Image(
                painter = rememberImagePainter(data = url),
                contentDescription = null
            )
        }


    }




}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}







