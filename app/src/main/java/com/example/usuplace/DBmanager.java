package com.example.usuplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuplace.User;

public class DBmanager {
    private DB dbHelper;

    public DBmanager(Context context) {
        dbHelper = new DB(context);
    }

    public void addUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("phone", user.getPhone());
        values.put("municipality", user.getMunicipality());
        values.put("department", user.getDepartment());
        values.put("password", user.getPassword());

        db.insert("users", null, values);
        db.close();
    }

    public boolean checkUserExists(String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = {"id"};
        String selection = "email = ?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();

        return exists;
    }

    public boolean checkLoginCredentials(String email, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = {"id"};
        String selection = "email = ? AND password = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
        boolean validCredentials = (cursor.getCount() > 0);
        cursor.close();
        db.close();

        return validCredentials;
    }

    public boolean checkUserCredentials(String email, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection = "email" + " = ?" + " AND " + "password" + " = ?";
        String[] selectionArgs = { email, password };
        Cursor cursor = db.query("users", null, selection, selectionArgs, null, null, null);

        boolean result = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return result;
    }

}
