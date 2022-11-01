package com.silva.contact_rename.chagebyhour

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged
import com.silva.contact_rename.chagebyhour.data.repository.ContactChangedRepositoryImpl
import com.silva.contact_rename.chagebyhour.domain.repository.ContactsChangedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ChangeByHourViewModel @Inject constructor(
    private val repository: ContactsChangedRepository
) : ViewModel() {

    private val _newName = mutableStateOf<String>("")
    val newName: State<String> = _newName

    private val _oldName = mutableStateOf<String>("")
    val oldName: State<String> = _oldName

    private val _isOnSwitch = mutableStateOf<Boolean>(false)
    val isOnSwitch: State<Boolean> = _isOnSwitch

    private val _timeStart = mutableStateOf<String>("00:00")
    val timeStart: State<String> = _timeStart

    private val _timeEnd = mutableStateOf<String>("00:00")
    val timeEnd: State<String> = _timeEnd


    private val _monday = mutableStateOf<Boolean>(false)
    val monday: State<Boolean> = _monday

    private val _thursday = mutableStateOf<Boolean>(false)
    val thursday: State<Boolean> = _thursday

    private val _wednesday = mutableStateOf<Boolean>(false)
    val wednesday: State<Boolean> = _wednesday

    private val _tuesday = mutableStateOf<Boolean>(false)
    val tuesday: State<Boolean> = _tuesday

    private val _friday = mutableStateOf<Boolean>(false)
    val friday: State<Boolean> = _friday

    private val _saturday = mutableStateOf<Boolean>(false)
    val saturday: State<Boolean> = _saturday

    private val _sunday = mutableStateOf<Boolean>(false)
    val sunday: State<Boolean> = _sunday


    fun onChangeTimeStart(newTimeStart: String) {
        _timeStart.value = newTimeStart
    }

    fun onChangeTimeEnd(newTimeEnd: String) {
        _timeEnd.value = newTimeEnd
    }

    fun onChangeNewName(name: String) {
        _newName.value = name
    }

    fun onChangeOldName(oldName: String) {
        _oldName.value = oldName
    }

    fun onChangeSwitch(newValue: Boolean) {
        _isOnSwitch.value = newValue
    }

    fun changeMonday() {
        _monday.value = !_monday.value
    }

    fun changeTuesday() {
        _tuesday.value = !_tuesday.value
    }

    fun changeWednesday() {
        _wednesday.value = !_wednesday.value
    }

    fun changeThursday() {
        _thursday.value = !_thursday.value
    }

    fun changeFriday() {
        _friday.value = !_friday.value
    }

    fun changeSaturday() {
        _saturday.value = !_saturday.value
    }

    fun changeSunday() {
        _sunday.value = !_sunday.value
    }

    fun registerChange() {
        viewModelScope.launch {
            repository.insertContactChanged(
                ContactChanged(
                    oldName = _oldName.value,
                    newName = _newName.value,
                )
            )

        }

    }
}