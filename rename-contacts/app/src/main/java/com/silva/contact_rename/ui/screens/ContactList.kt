package com.silva.contact_rename.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.silva.contact_rename.Contact
import contacts.core.BroadQuery

@Composable
fun ContactList(contactList: BroadQuery.Result) {
    LazyColumn (modifier = Modifier.fillMaxSize()){
        items(contactList){ contact ->
            Contact(name = contact.displayNamePrimary?: "no name", contact.photoUri)
        }
    }
}