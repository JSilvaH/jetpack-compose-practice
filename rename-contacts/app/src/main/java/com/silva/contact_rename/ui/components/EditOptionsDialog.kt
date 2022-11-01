package com.silva.contact_rename.ui.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.silva.contact_rename.chagebyhour.ChangeByHourActivity
import com.silva.contact_rename.ui.theme.ContactrenameTheme

@Composable
fun EditOptionDialog(
    title: String,
    description: String,
    nameContact: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                ),


            ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                        .height(150.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = title,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = description,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 10.dp, end = 10.dp),
                            shape = RoundedCornerShape(20.dp)

                        ) {
                            Text(text = "Mapa")
                        }

                        Button(
                            onClick = {
                                context.startActivity(
                                    Intent(
                                        context,
                                        ChangeByHourActivity::class.java
                                    ).putExtra("oldName", nameContact)
                                )
                                onDismiss()
                            },
                            modifier = Modifier
                                .weight(2f)
                                .padding(end = 10.dp),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(text = "Por hora")
                        }
                    }
                }


            }

        }
    }
}


@Preview
@Composable
fun EditOptionDialogPreview() {
//    ContactrenameTheme {
//        EditOptionDialog(
//            "Preview",
//            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quam justo, pretium at turpis id, ullamcorper sagittis urna. Praesent condimentum, nisl nec hendrerit tristique, eros ipsum porttitor enim, id consequat augue libero ut mi. ",
//            {},
//
//        )
//    }
}