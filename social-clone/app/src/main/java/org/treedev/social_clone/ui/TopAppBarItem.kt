package org.treedev.social_clone.ui

import org.treedev.social_clone.R

sealed class TopAppBarItem(
    var resource: Int,
    var screenRoute: String
){
    object AddPost: TopAppBarItem(R.drawable.ic_add, "add")
    object Likes: TopAppBarItem(R.drawable.ic_likes, "likes")
    object Messages: TopAppBarItem(R.drawable.ic_send, "my_messages")

}
