package com.example.maquiagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public class DatabaseHelper extends SQLiteOpenHelper{
        private static final String BD = "NomeBD";
        private static int VERSAO = 1;
        public DatabaseHelper(Context context){
            super(context, BD, null, VERSAO);
        }
        @Override public void onCreate(SQLiteDatabase db){}
        @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {} }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table Tags" +
                        "(id integer primary key, brand text, name text, price decimal, currency text, " +
                        "image_link string, website_link string, description text, category text, tag_list text," +
                        " created_at datetime, updated_at datetime, product_api_url string, api_featured_image string, product_colors text)"
        );
        db.execSQL(
                "create table Tipos" +
                        "(id integer primary key, brand text, name text, price decimal, currency text, " +
                        "image_link string, website_link string, description text, category text, tag_list text," +
                        " created_at datetime, updated_at datetime, product_api_url string, api_featured_image string, product_colors text)"
        );
    }
}