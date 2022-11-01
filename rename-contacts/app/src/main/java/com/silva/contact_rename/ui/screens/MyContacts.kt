package com.silva.contact_rename.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silva.contact_rename.MainViewModel
import com.silva.contact_rename.ui.components.ContactList
import contacts.core.Contacts

@Composable
fun MyContacts() {
    val viewModel: MainViewModel = hiltViewModel()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val contacts = Contacts(LocalContext.current)
            .broadQuery()
            .wherePartiallyMatches(viewModel.contactNameSearch.value)
            .find()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                value = viewModel.contactNameSearch.value,
                onValueChange = { viewModel.onChangeContactSearch(it) },
                label = { Text("Contacto") },
                placeholder = {
                    Text(text = "Type something ...")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                }
            )
            ContactList(contacts)
        }
    }
}