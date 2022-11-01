package com.silva.contact_rename.chagebyhour.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.silva.contact_rename.chagebyhour.data.db.daos.ContactChangedDao
import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged

@Database(entities = [
    ContactChanged::class
], version = 1)
abstract class ContactChangedDatabase: RoomDatabase() {
    abstract fun contactChangedDao(): ContactChangedDao
}