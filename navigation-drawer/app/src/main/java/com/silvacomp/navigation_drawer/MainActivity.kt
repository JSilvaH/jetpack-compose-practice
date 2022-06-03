package com.silvacomp.navigation_drawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.silvacomp.navigation_drawer.navigation_drawer_components.AppBar
import com.silvacomp.navigation_drawer.navigation_drawer_components.DrawerBody
import com.silvacomp.navigation_drawer.navigation_drawer_components.DrawerHeader
import com.silvacomp.navigation_drawer.navigation_drawer_components.MenuItem
import com.silvacomp.navigation_drawer.ui.theme.NavigationdrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myItems = listOf(
            MenuItem(
                id = "home",
                title = "Home",
                contentDescription = " go home screen",
                icon = Icons.Default.Home
            ),
            MenuItem(
                id = "settings",
                title = "Settings",
                contentDescription = " go settings screen",
                icon = Icons.Default.Settings
            ),
            MenuItem(
                id = "help",
                title = "Help",
                contentDescription = " help",
                icon = Icons.Default.Info
            )
        )
        setContent {
            NavigationdrawerTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                             AppBar (
                                 onNavigationActionClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.open()
                                    }
                                 }
                             )
                    },
                    //this next lines is used to use the drawer gesture , when the drawer is open
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = myItems,
                            onItemClick = {
                                println("You clicked on ${it.title}")
                            }
                        )
                    }
                ){

                }
            }
        }
    }

}