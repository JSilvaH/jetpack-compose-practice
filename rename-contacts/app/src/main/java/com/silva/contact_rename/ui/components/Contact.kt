package com.silva.contact_rename

import android.icu.text.CaseMap
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.silva.contact_rename.ui.components.EditOptionDialog

@Composable
fun Contact(name: String, image: Uri?) {
    val openDialog = remember { mutableStateOf(false)  }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)
        .clickable { openDialog.value = true }
        .height(80.dp),
        elevation = 8.dp,

    ) {
        if (openDialog.value) {
            EditOptionDialog(
                title = "Configurar",
                description = "Elige una forma  para configurar la forma en que deseas" +
                        "que cambie el nombre",
                nameContact = name
            ) { openDialog.value = false }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 5.dp),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontFamily = FontFamily.Default
                ),
                text = name
            )
            if (image != null){
                Image(
                    painter =  rememberAsyncImagePainter(image),
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                    contentDescription = null
                )

            }else {
                Image(
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                    painter = painterResource(R.drawable.contact_logo),
                    contentDescription = null
                )

            }

        }
    }
}


@Preview
@Composable
fun ContactPreview() {
    Contact(name = "Test", null)
}