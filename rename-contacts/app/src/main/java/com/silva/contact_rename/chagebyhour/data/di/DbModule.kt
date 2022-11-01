package com.silva.contact_rename.chagebyhour.data.di

import android.content.Context
import androidx.room.Room
import com.silva.contact_rename.chagebyhour.data.db.ContactChangedDatabase
import com.silva.contact_rename.chagebyhour.data.db.daos.ContactChangedDao
import com.silva.contact_rename.chagebyhour.data.repository.ContactChangedRepositoryImpl
import com.silva.contact_rename.chagebyhour.domain.repository.ContactsChangedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ): ContactChangedDatabase{
        return Room.databaseBuilder(
            context,
            ContactChangedDatabase::class.java,
            "contactchanged.db"
        ).build()
    }

    @Provides
    fun providesContactsChanged(contactChangedDatabase: ContactChangedDatabase): ContactChangedDao = contactChangedDatabase.contactChangedDao()

    @Provides
    @Singleton
    fun provideRepository(
        db: ContactChangedDatabase
    ): ContactsChangedRepository{
        return  ContactChangedRepositoryImpl(db.contactChangedDao())

    }
}