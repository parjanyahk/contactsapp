package com.example.android.contactsapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contact.class},version = 1, exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {
    abstract ContactDao contactDao();

    private static ContactDatabase INSTANCE = null;

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static ContactDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (ContactDatabase.class){
                if(INSTANCE == null){
                    INSTANCE= Room.databaseBuilder(
                            context.getApplicationContext()
                            ,ContactDatabase.class
                            ,"State"
                    ).addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull final SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            executor.execute(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });
                        }
                    }).fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}