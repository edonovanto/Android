package com.android.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "dbname.db";
    private static final Integer DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "sqlite";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_PHONE + " TEXT NOT NULL, "
                + COLUMN_ADDRESS + " TEXT NOT NULL "
                + ")";
        db.execSQL(query);

        query = "INSERT INTO " + TABLE_NAME + " VALUES('0',"
                + "'Budi Setiawan',"
                + "'123456789',"
                + "'Jaksel'"
                + ")";
        db.execSQL(query);

        insert(db,"Budi Setiawan", "123456789", "Jaksel");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insert(SQLiteDatabase db, String name, String phone, String address) {
        String query = "INSERT INTO " + TABLE_NAME + "("+COLUMN_NAME+","+COLUMN_PHONE+","+COLUMN_ADDRESS+") VALUES("
                + "'" + name + "',"
                + "'" + phone + "',"
                + "'" + address + "'"
                + ")";
        db.execSQL(query);
    }

    public void update(int id, String name, String phone, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET "
                + "name='" + name + "',"
                + "phone='" + phone + "',"
                + "address='" + address + "'"
                + " WHERE id="+id;
        db.execSQL(query);
    }

    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME
                + " WHERE id="+id;
        db.execSQL(query);
    }
}
