package com.silva.contact_rename.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.silva.contact_rename.ui.components.BottomNavItem

@Composable
fun BottomNavigationContact(navController: NavController) {
    val items = listOf(
        BottomNavItem.MyContacts,
        BottomNavItem.MyContactsChanged
    )

    BottomNavigation(
        contentColor = Color.White,

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route




        BottomNavigationItem(
            icon = {
                Icon(
                    painterResource(id = BottomNavItem.MyContacts.icon),
                    contentDescription = null,
                    modifier = Modifier.size(29.dp)
                )
            },
            modifier = Modifier
                .background(color = MaterialTheme.colors.secondary)
                .graphicsLayer {
                    clip = true
                    shape = RoundedCornerShape(topEnd = 60.dp)
                    shadowElevation = 2.2f
                },
            selectedContentColor = MaterialTheme.colors.primary,
            unselectedContentColor = Color.Black.copy(0.4f),
            alwaysShowLabel = true,
            selected = currentRoute == BottomNavItem.MyContacts.screen,
            onClick = {
                navController.navigate(BottomNavItem.MyContacts.screen) {
                    navController.graph.startDestinationRoute?.let { screenRoute ->
                        popUpTo(screenRoute) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )


        BottomNavigationItem(
            modifier = Modifier
                .background(color = MaterialTheme.colors.secondary)
                .graphicsLayer {
                    clip = true
                    shape = RoundedCornerShape(topStart = 60.dp)
                    shadowElevation = 2.2f
                },
            icon = {
                Icon(
                    painterResource(id = BottomNavItem.MyContactsChanged.icon),
                    contentDescription = null,
                    modifier = Modifier.size(29.dp)
                )
            },
            selectedContentColor = MaterialTheme.colors.primary,
            unselectedContentColor = Color.Black.copy(0.4f),
            alwaysShowLabel = true,

            selected = currentRoute == BottomNavItem.MyContactsChanged.screen,
            onClick = {
                navController.navigate(BottomNavItem.MyContactsChanged.screen) {
                    navController.graph.startDestinationRoute?.let { screenRoute ->
                        popUpTo(screenRoute) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

//        items.forEach { item ->
//
//        }

    }
}