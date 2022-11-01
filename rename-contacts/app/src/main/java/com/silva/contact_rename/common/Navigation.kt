package com.silva.contact_rename

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.silva.contact_rename.contact_renamed.presentation.MyContactRenamed
import com.silva.contact_rename.ui.components.BottomNavItem
import com.silva.contact_rename.ui.screens.MyContacts

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.MyContacts.screen ){
        composable(BottomNavItem.MyContacts.screen){ MyContacts()}
        composable(BottomNavItem.MyContactsChanged.screen){ MyContactRenamed()}
    }
}