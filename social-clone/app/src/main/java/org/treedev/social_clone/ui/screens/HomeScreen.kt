package org.treedev.social_clone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import org.treedev.social_clone.R
import org.treedev.social_clone.ui.elements.Post

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
       Stories()
        Posts()

    }
}


@Composable
fun Stories() {
    val stories = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
    LazyRow(
    ) {
        items(items = stories, itemContent = {item ->
           Storie(item)
        })
    }
}


@Composable
fun Storie(user: String) {
    Card(
        modifier = Modifier.padding(top = 7.dp, end = 8.dp),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberImagePainter("https://picsum.photos/seed/picsum/200"),
                contentDescription = null,
                modifier = Modifier
                    .size(65.dp)
                    .clip(CircleShape)
            )
            Text(text = user, fontSize = 15.sp)
        }
        
    }
}

@Composable
fun Posts() {
    val list = listOf(1,2,3)
    LazyColumn (Modifier.fillMaxSize()){
        items(items = list, itemContent = {item ->
            Post()
        })

    }
}