package org.treedev.social_clone.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import org.treedev.social_clone.R

@Preview
@Composable
fun Post() {
    val imagesPost = listOf(1)
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp, start = 14.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    rememberImagePainter("https://picsum.photos/id/237/200"),
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape),
                    contentDescription = null
                )
                Text(text = "Username", fontSize = 18.sp, modifier = Modifier.padding(start = 4.dp))


            }
            LazyRow() {
                items(items = imagesPost, itemContent = { item ->
                    Image(
                        rememberImagePainter("https://picsum.photos/id/537/200"),
                        modifier = Modifier
                            .size(345.dp)
                            .padding(top = 6.dp),
                        contentDescription = null
                    )
                })
            }

            Row() {
                IconButton(onClick = { /*TODO*/ } ) {
                    Icon(painter = painterResource(id = R.drawable.ic_likes), contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_comments), contentDescription = null)
                }
                
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_send), contentDescription = null )
                    
                }
                Spacer(modifier =Modifier.width(170.dp))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_save_post), contentDescription =  null)
                }
            }
            Text(text = "N Me gusta",  fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = "Username: Description photo ....", fontSize = 14.sp)
            Text(text = "Ver los N comentarios", fontSize = 10.sp)
        }





    }

}