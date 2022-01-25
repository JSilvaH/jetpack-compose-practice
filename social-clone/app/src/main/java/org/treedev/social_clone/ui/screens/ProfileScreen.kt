package org.treedev.social_clone.ui.screens

import android.graphics.Color.blue
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.treedev.social_clone.R

@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(65.dp)
                    .clip(CircleShape)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End

            ) {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = "11", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Publicaciones", fontSize = 12.sp)
                }

                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = "79", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Seguidores", fontSize = 12.sp)
                }

                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.padding(start = 10.dp)
                ){
                    Text(text = "450", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Seguidos", fontSize = 12.sp)
                }
            }

        }
        Row {
            Text(
                text = "Username",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(4f)
                    .background(Color.Transparent)
                    .border(BorderStroke(width = 1.dp, color = Color.Black))
            ) {
                Text(text = "Editar Perfil")

            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_add_person), contentDescription = null)
            }
        }

        Row(
        ) {
            Text(text = "Descubre personas", fontWeight = FontWeight.Bold, modifier = Modifier
                .weight(1f)
                .fillMaxWidth())
            Text(
                text = "Ver todo",
                fontSize = 16.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp),
                textAlign = TextAlign.End
            )
        }
        LazyRow(){

        }

    }
}