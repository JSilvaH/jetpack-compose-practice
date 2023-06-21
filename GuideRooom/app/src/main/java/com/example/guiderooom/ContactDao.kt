package com.example.guiderooom

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Upsert
    suspend fun deleteContact(contact: Contact)


    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    fun getContactOrderedByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContactOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContactOrderedByPhoneNumber(): Flow<List<Contact>>
}