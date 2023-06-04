package com.example.acsitp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MaladieDAO {
    private DatabaseHelper dbHelper;

    public MaladieDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long addMaladie(Maladie maladie) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MaladieContract.MaladieEntry.COLUMN_TITLE, maladie.getName());
        values.put(MaladieContract.MaladieEntry.COLUMN_DESCRIPTION, maladie.getDescription());


        long newRowId = db.insert(MaladieContract.MaladieEntry.TABLE_NAME, null, values);
        db.close();

        return newRowId;
    }
    public void deleteData(String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + MaladieContract.MaladieEntry.TABLE_NAME + " WHERE " + MaladieContract.MaladieEntry.COLUMN_TITLE + " = ?";
        db.execSQL(deleteQuery, new String[]{name});
        db.close();
    }
    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + MaladieContract.MaladieEntry.TABLE_NAME;
        db.execSQL(deleteQuery);
        db.close();
    }

    public List<Maladie> getAllmaladies() {
        List<Maladie> maladies = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                MaladieContract.MaladieEntry._ID,
                MaladieContract.MaladieEntry.COLUMN_TITLE,
                MaladieContract.MaladieEntry.COLUMN_DESCRIPTION,

        };

        Cursor cursor = db.query(
                MaladieContract.MaladieEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            Maladie announcement = new Maladie();
            announcement.setId(cursor.getLong(cursor.getColumnIndexOrThrow(MaladieContract.MaladieEntry._ID)));
            announcement.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MaladieContract.MaladieEntry.COLUMN_TITLE)));
            announcement.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(MaladieContract.MaladieEntry.COLUMN_DESCRIPTION)));


            maladies.add(announcement);
        }

        cursor.close();
        db.close();

        return maladies;
    }

    // Implement methods for updating, deleting announcements if needed

}
