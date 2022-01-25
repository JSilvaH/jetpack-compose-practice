package org.treedev.social_clone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.treedev.social_clone.ui.BottomNavItem
import org.treedev.social_clone.ui.TopAppBarItem
import org.treedev.social_clone.ui.screens.*

@ExperimentalFoundationApi
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screen_rout) {
        composable(BottomNavItem.Home.screen_rout) { HomeScreen() }
        composable(BottomNavItem.Search.screen_rout) { SearchScreen() }
        composable(BottomNavItem.Reels.screen_rout) { ReelsScreen() }
        composable(BottomNavItem.Store.screen_rout) { StoreScreen() }
        composable(BottomNavItem.Profile.screen_rout) { ProfileScreen() }
        composable(TopAppBarItem.AddPost.screenRoute) { AddPostScreen() }
        composable(TopAppBarItem.Likes.screenRoute) { LikesScreen() }
        composable(TopAppBarItem.Messages.screenRoute) { MessageScreen() }
    }
}