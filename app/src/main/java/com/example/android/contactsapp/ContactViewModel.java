package com.example.android.contactsapp;

import android.app.Application;
import androidx.annotation.NonNull;
import  androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;


public class ContactViewModel extends AndroidViewModel {

    private ContactRepository contactRepository;

    private LiveData<PagedList<Contact>> data;

    public ContactViewModel(@NonNull Application application) {
        super (application);
    }

}
