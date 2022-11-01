package com.silva.contact_rename.contact_renamed.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged
import com.silva.contact_rename.contact_renamed.data.repository.ContactRenamedRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyContactsRenamedViewModel @Inject constructor(
    private val repository: ContactRenamedRepositoryImpl
):ViewModel() {

    private val _listContactsChanged = mutableStateOf<List<ContactChanged>>(emptyList())
    val listContactsChanged: State<List<ContactChanged>> =_listContactsChanged


    fun getMyContactsRenamed() {
        viewModelScope.launch {
            _listContactsChanged.value = repository.getAllContactsRenamed()
        }
    }

}