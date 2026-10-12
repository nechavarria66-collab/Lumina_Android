package com.biblioteca.lumina.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lumina.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_LIBROS = "libros";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITULO = "titulo";
    public static final String COLUMN_AUTOR = "autor";
    public static final String COLUMN_CATEGORIA = "categoria";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LIBROS_TABLE = "CREATE TABLE " + TABLE_LIBROS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITULO + " TEXT, "
                + COLUMN_AUTOR + " TEXT, "
                + COLUMN_CATEGORIA + " TEXT)";
        db.execSQL(CREATE_LIBROS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIBROS);
        onCreate(db);
    }
}