package com.example.android.contactsapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contact")

public class Contact {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long contact_id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Number")
    private int number;

    @ColumnInfo(name = "Email Address")
    private String email_id;

    @ColumnInfo(name = "Age")
    private int age;

    @ColumnInfo(name = "City")
    private String city;

    @ColumnInfo(name = "College")
    private String college;

    public Contact(long contact_id, String name, int number, String email_id, int age, String city, String college) {
        this.contact_id = contact_id;
        this.name = name;
        this.number = number;
        this.email_id = email_id;
        this.age = age;
        this.city = city;
        this.college = college;
    }

    //Getter and Setter

    public long getContact_id() {
        return contact_id;
    }


    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}