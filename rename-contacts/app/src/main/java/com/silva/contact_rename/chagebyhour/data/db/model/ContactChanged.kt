package com.silva.contact_rename.chagebyhour.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactChanged(
    @PrimaryKey(autoGenerate = true)
    val uid:Int = 0,
    val oldName: String,
    val newName: String
)
