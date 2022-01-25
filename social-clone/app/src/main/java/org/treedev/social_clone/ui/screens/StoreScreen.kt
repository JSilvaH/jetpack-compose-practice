package org.treedev.social_clone.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import org.treedev.social_clone.R
import kotlin.random.Random

@ExperimentalFoundationApi
@Preview
@Composable
fun StoreScreen() {
    var value by remember { mutableStateOf("") }
    val list = List(60){ Random.nextInt(0, 999)}
    val category = listOf("Tiendas", "Videos", "Sugerencias de editores", "Colecciones", "Guias")
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        TextField(
            value = value,
            onValueChange = { value = it },
            placeholder = { Text("Search") },
            shape = RoundedCornerShape(6.dp),
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

        LazyRow(
            modifier = Modifier.padding(start = 8.dp)
        ){
            items(items = category, itemContent = {item ->
               Card(
                   backgroundColor = Color.White,
                   border = BorderStroke(1.dp, Color.Black),
                   modifier = Modifier.padding(end = 7.dp)
               ) {
                   Text(
                       text = item,
                       fontWeight = FontWeight.Bold,
                       fontSize = 16.sp,
                       modifier = Modifier.padding(5.dp)
                   )
               }
            })
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            state = rememberLazyListState(),
            modifier = Modifier.padding(top = 5.dp)
        ) {
            items(list.size) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(1.dp)
                ) {
                    Image(
                        painter = rememberImagePainter("https://picsum.photos/id/$index/200/"),
                        modifier = Modifier
                            .size(200.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }

                }



        }
    }
}