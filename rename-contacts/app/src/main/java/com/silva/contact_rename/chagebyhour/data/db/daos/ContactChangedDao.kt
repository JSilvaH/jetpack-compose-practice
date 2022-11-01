package com.silva.contact_rename.chagebyhour.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged

@Dao
interface ContactChangedDao {
    @Query("SELECT * FROM ContactChanged")
    fun getContactsChanged() : List<ContactChanged>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContactChanged(contactChanged: ContactChanged)
}