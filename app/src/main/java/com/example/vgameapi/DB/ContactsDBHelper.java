package com.example.vgameapi.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.vgameapi.DB.ContactsContract.*;
import com.example.vgameapi.Model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ContactsEntry.TABLE_NAME + "(" + ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ContactsEntry.COLUMN_NAME_TITLE + " TEXT)";

    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertContact(SQLiteDatabase db, Contact c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(ContactsEntry.COLUMN_NAME_TITLE, c.getNom());

            db.insert(ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    @SuppressLint("Range")
    public List<Contact> retrieveContacts(SQLiteDatabase db) {
        List<Contact> contacts = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + ContactsEntry.TABLE_NAME;

        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(cursor.getString(cursor.getColumnIndex("name")));
                contacts.add(contact);
            } while (cursor.moveToNext());
        }
        return contacts;
    }

    public void deleteDatabase(SQLiteDatabase db) {
        this.deleteDatabase(db);
    }
}
