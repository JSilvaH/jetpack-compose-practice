package com.silva.contact_rename.chagebyhour.data.repository

import com.silva.contact_rename.chagebyhour.data.db.daos.ContactChangedDao
import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged
import com.silva.contact_rename.chagebyhour.domain.repository.ContactsChangedRepository
import javax.inject.Inject

class ContactChangedRepositoryImpl @Inject constructor(
    private val contactChangedDao: ContactChangedDao
): ContactsChangedRepository {

    override suspend fun insertContactChanged(contactChanged: ContactChanged) {
            contactChangedDao.insertContactChanged(contactChanged)
    }
}