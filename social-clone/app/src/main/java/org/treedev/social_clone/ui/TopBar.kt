package org.treedev.social_clone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.treedev.social_clone.R


@Composable
fun MyTopBar(navController: NavController) {
    val items = listOf(
        TopAppBarItem.AddPost,
        TopAppBarItem.Likes,
        TopAppBarItem.Messages
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    TopAppBar(
        title = {
            Image(
                modifier = Modifier.size(110.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
        },
        navigationIcon = null,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 10.dp,

        actions = {
            IconButton(onClick = {navController.navigate("add")}) {
                Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
            }
            IconButton(onClick = {navController.navigate("likes")}) {
                Icon(painter = painterResource(id = R.drawable.ic_likes), contentDescription = null)
            }
            IconButton(onClick = { navController.navigate("my_messages")}) {
                Icon(painter = painterResource(id = R.drawable.ic_send), contentDescription = null)
            }

        }
    )
}




