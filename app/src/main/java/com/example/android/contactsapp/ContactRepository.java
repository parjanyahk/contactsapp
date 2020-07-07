package com.example.android.contactsapp;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContactRepository {

    public Contact contact;

    private static ContactRepository repository = null;

    private ContactDao contactDao;

    private static int PAGE_SIZE = 15;

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public ContactRepository(Application application) {
        ContactDatabase db = ContactDatabase.getInstance(application);
        contactDao = db.contactDao();
    }

    public static ContactRepository getRepository(Application application) {
        if (repository == null) {
            synchronized (ContactRepository.class) {
                if (repository == null) {
                    repository = new ContactRepository(application);
                }
            }
        }
        return repository;
    }

    public void insertTask(final Contact contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.insertContact(contact);
            }
        });
    }

    public void updateTask(final Contact contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.updateContact(contact);
            }
        });
    }

    public void deleteTask(final Contact contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.deleteContact(contact);
            }
        });
    }

    public LiveData<PagedList<Contact>> getAllContacts() {
        return new LivePagedListBuilder<>(
                contactDao.getAllContacts(), PAGE_SIZE
        ).build();
    }
}