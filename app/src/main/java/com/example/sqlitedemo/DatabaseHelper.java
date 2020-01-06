package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "IDU.db";
    public static final String TABLE_NAME = "IDU";
    //column
    public static final String COLS_1 = "ID";
    public static final String COLS_2 = "name";
    public static final String COLS_3 = "email";
    public static final String COLS_4 = "address";
    public static final String COLS_5 = "phone";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,email TEXT, address TEXT,phone TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
