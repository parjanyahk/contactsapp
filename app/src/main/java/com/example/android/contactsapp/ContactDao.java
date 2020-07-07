package com.example.android.contactsapp;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("Select * from Contact ORDER BY Name ASC")
    DataSource.Factory<Integer, Contact> getAllContacts();
}