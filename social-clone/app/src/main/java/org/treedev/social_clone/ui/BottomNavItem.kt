package org.treedev.social_clone.ui

import org.treedev.social_clone.R

sealed class BottomNavItem(
    var icon: Int,
    var screen_rout: String
){
    object Home: BottomNavItem( R.drawable.ic_home, "home")
    object Search: BottomNavItem(R.drawable.ic_search, "search")
    object Reels: BottomNavItem(R.drawable.ic_reels, "reels")
    object Store: BottomNavItem(R.drawable.ic_store, "store")
    object Profile: BottomNavItem(R.drawable.ic_profile, "profile")
}
