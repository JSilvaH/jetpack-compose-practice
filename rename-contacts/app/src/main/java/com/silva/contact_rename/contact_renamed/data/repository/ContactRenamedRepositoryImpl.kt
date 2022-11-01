package com.silva.contact_rename.contact_renamed.data.repository

import android.util.Log
import com.silva.contact_rename.chagebyhour.data.db.daos.ContactChangedDao
import com.silva.contact_rename.chagebyhour.data.db.model.ContactChanged
import com.silva.contact_rename.contact_renamed.domain.ContactsRenamedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactRenamedRepositoryImpl @Inject constructor(
    private val contactChangedDao: ContactChangedDao
) : ContactsRenamedRepository {
    override suspend fun getAllContactsRenamed(): List<ContactChanged> {
        return withContext(Dispatchers.IO){
            val response = contactChangedDao.getContactsChanged()
            response
        }
    }
}