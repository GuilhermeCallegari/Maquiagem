package com.example.maquiagem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BD = "maquigemDB";
    private static int VERSAO = 1;
    public DatabaseHelper(Context context){
        super(context, BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table tags" +
                        "(id integer primary key, brand text, name text, price decimal, currency text, " +
                        "image_link string, description text, category text, tag_list text, " +
                        "api_featured_image string)"
        );
        db.execSQL(
                "create table tipos" +
                        "(id integer primary key, brand text, name text, price decimal, currency text, " +
                        "image_link string, description text, category text, tag_list text, " +
                        "api_featured_image string)"
        );
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
