package com.silva.contact_rename.chagebyhour

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silva.contact_rename.chagebyhour.ui.theme.ContactrenameTheme
import com.silva.contact_rename.ui.components.DayCheckBox
import contacts.core.Contacts
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class ChangeByHourActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val oldName: String? = intent.getStringExtra("oldName")
        setContent {
            ContactrenameTheme {
                // A surface container using the 'background' color from the theme
                val activity = (LocalContext.current as Activity)
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Elige la hora")
                            },
                            navigationIcon = {
                                IconButton(onClick = { activity.finish() }) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = null
                                    )
                                }
                            }

                        )
                    }
                ) {
                    FormByHour(oldName)

                }

            }
        }
    }
}

@Composable
fun FormByHour(oldName: String?) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val viewModel: ChangeByHourViewModel = hiltViewModel()
        viewModel.onChangeOldName(oldName ?: "no name")
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]
        val timerStart = TimePickerDialog(
            LocalContext.current,
            { _, mHour: Int, mMinute: Int ->
                viewModel.onChangeTimeStart("$mHour:$mMinute")
            }, mHour, mMinute, false
        )

        val timerEnd = TimePickerDialog(
            LocalContext.current,
            { _, mHour: Int, mMinute: Int ->
                viewModel.onChangeTimeEnd("$mHour:$mMinute")
            }, mHour, mMinute, false
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            value = viewModel.oldName.value,
            onValueChange = { viewModel.onChangeOldName(it) },
            enabled = false,
            label = {
                Text(text = "Nombre original")
            }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            value = viewModel.newName.value,
            onValueChange = { viewModel.onChangeNewName(it) },
            label = {
                Text(text = "Ingresa el numero para cambiar")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Hora inicio",
                    fontSize = 25.sp
                )
                Text(
                    text = viewModel.timeStart.value,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .clickable {
                            timerStart.show()
                        }
                )
            }

            Column {
                Text(
                    text = "Hora Fin",
                    fontSize = 25.sp
                )
                Text(
                    text = viewModel.timeEnd.value,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .clickable { timerEnd.show() }
                )
            }


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Switch(
                checked = viewModel.isOnSwitch.value,
                onCheckedChange = { viewModel.onChangeSwitch(it) },
                modifier = Modifier.height(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Elige los dias disponibles para que funcione"
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DayCheckBox(
                day = "D",
                selected = viewModel.sunday.value,
                onChecked = { viewModel.changeSunday() }
            )
            DayCheckBox(
                day = "L",
                selected = viewModel.monday.value,
                onChecked = { viewModel.changeMonday() }
            )

            DayCheckBox(
                day = "M",
                selected = viewModel.tuesday.value,
                onChecked = { viewModel.changeTuesday() }
            )

            DayCheckBox(
                day = "M",
                selected = viewModel.wednesday.value,
                onChecked = { viewModel.changeWednesday() }
            )

            DayCheckBox(
                day = "J",
                selected = viewModel.thursday.value,
                onChecked = { viewModel.changeThursday() }
            )

            DayCheckBox(
                day = "V",
                selected = viewModel.friday.value,
                onChecked = { viewModel.changeFriday() }
            )

            DayCheckBox(
                day = "S",
                selected = viewModel.saturday.value,
                onChecked = { viewModel.changeSaturday() }
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            onClick = { viewModel.registerChange() },
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Programar")
        }


    }
}

private fun updateNameContact(context: Context,oldName: String,newName: String){
    val update = Contacts(context)
        .update()
        .contacts()
}

@Preview(
    showBackground = true
)
@Composable
fun ChangeByHourActivityPrev() {
    ContactrenameTheme {
        FormByHour("Jesus")


    }
}

