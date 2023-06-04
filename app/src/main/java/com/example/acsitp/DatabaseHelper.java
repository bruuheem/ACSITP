package com.example.acsitp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.net.ConnectException;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " +
                MaladieContract.MaladieEntry.TABLE_NAME + " (" +
                MaladieContract.MaladieEntry._ID + " INTEGER PRIMARY KEY, " +
                MaladieContract.MaladieEntry.COLUMN_TITLE + " TEXT, " +
                MaladieContract.MaladieEntry.COLUMN_DESCRIPTION + " TEXT, " +
                MaladieContract.MaladieEntry.COLUMN_SYP+"TEXT)";


        db.execSQL(createTableQuery);
        db.execSQL("create Table users(email TEXT primary key, password TEXT ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +MaladieContract.MaladieEntry.TABLE_NAME);
        onCreate(db);
        db.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor  = db.rawQuery("Select * from users where email = ?", new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor  = db.rawQuery("Select * from users where email = ? and password = ?", new String[]{email, password});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
