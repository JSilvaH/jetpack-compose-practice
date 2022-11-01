package com.silva.contact_rename

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import contacts.core.BroadQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val _contactNameSearch = mutableStateOf<String>("")
    val contactNameSearch: State<String> =_contactNameSearch
    
    private val _showDialog = mutableStateOf<Boolean>(false)
    val showDialog: State<Boolean> =_showDialog

    fun onChangeContactSearch(contact: String){
        _contactNameSearch.value = contact
    }


}