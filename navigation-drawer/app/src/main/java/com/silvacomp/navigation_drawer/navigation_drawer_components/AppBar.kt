package com.silvacomp.navigation_drawer.navigation_drawer_components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.silvacomp.navigation_drawer.R

@Composable
fun AppBar(
    onNavigationActionClick: () -> Unit
) {
    TopAppBar (
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationActionClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu"
                )
            }
        }
    )
    
}