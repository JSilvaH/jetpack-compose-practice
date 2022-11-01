package com.silva.contact_rename.contact_renamed.domain

import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged

interface ContactsRenamedRepository {
    suspend fun getAllContactsRenamed() : List<ContactChanged>
}