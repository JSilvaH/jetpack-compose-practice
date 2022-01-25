package org.treedev.social_clone.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import org.treedev.social_clone.R
import kotlin.random.Random

@ExperimentalFoundationApi
@Preview
@Composable
fun SearchScreen() {
    var value by remember { mutableStateOf("") }
    val list = List(60){ Random.nextInt(0, 999)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {

        TextField(
            value = value,
            onValueChange = { value = it },
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            },
            trailingIcon = {
                if (value.isNotBlank())
                    IconButton(onClick = { value = "" }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cancel),
                            contentDescription = "Limpiar campo de nombre"
                        )
                    }
            },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            )

        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            state = rememberLazyListState()
        ) {
            items(list.size) { index ->
//                Card(
//                    backgroundColor = Color.Transparent,
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .fillMaxWidth(),
//                    elevation = 8.dp
//                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 5.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter("https://picsum.photos/id/$index/200/"),
                            modifier = Modifier
                                .size(100.dp),
                            contentDescription = null
                        )
                    }

//                }

            }

        }
    }
}