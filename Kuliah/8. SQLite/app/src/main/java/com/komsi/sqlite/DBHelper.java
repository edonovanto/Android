package com.komsi.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "sqlite_apk.db";
    public static final String TABLE_SQLite = "sqlite";

    public static final String COLUM_ID = "id";
    public static final String COLUM_NAME = "name";
    public static final String COLUM_PHONE = "phone";
    public static final String COLUM_ADDRESS = "address";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_SQLite +" ("+
                COLUM_ID + " INTEGER PRIMARY KEY autoincrement, " +
                COLUM_NAME + " TEXT NOT NULL, "+
                COLUM_PHONE + " TEXT NOT NULL, "+
                COLUM_ADDRESS + " TEXT NOT NULL"+
                ")";
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SQLite);
        onCreate(sqLiteDatabase);
    }
    public void insert(String name, String phone, String address){
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO "+ TABLE_SQLite + " (name, phone, address) "+
                "VALUES ('" + name + "', '" + phone + "' , '" + address + "')";

        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String name, String phone, String address){
        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = "UPDATE "+ TABLE_SQLite + " SET "
                + COLUM_NAME + "='" + name + "', "
                + COLUM_PHONE + "='" + phone + "', "
                + COLUM_ADDRESS + "='" + address + "'"
                + " WHERE " + COLUM_ID + "=" + "'" + id +"'";
        database.execSQL(updateQuery);
        database.close();
    }

    public void detele (int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = "DELETE FROM "+ TABLE_SQLite + " WHERE " + COLUM_ID + "=" + "'" + id +"'";
        database.execSQL(updateQuery);
        database.close();
    }
}
