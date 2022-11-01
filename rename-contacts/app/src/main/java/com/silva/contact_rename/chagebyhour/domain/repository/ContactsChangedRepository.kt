package com.silva.contact_rename.chagebyhour.domain.repository

import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged

interface ContactsChangedRepository {
    suspend fun insertContactChanged(contactChanged: ContactChanged)
}