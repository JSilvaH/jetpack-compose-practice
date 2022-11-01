package com.silva.contact_rename.ui.components

import com.silva.contact_rename.R

sealed class BottomNavItem(
    var icon: Int,
    var screen: String
){
    object MyContacts: BottomNavItem(R.drawable.ic_contact, "myContacts")
    object MyContactsChanged: BottomNavItem(R.drawable.ic_contact_renamed, "myContactsChanged")

}
